package store.com.retail_store.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.com.retail_store.customer.Customer;
import store.com.retail_store.customer.Product;
import store.com.retail_store.customer.Purchase;
import store.com.retail_store.customer.Wallet;
import store.com.retail_store.repository.CustomerRepository;
import store.com.retail_store.repository.WalletRepository;
import store.com.retail_store.service.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    private WalletRepository walletRepository;


    @Autowired
    private CustomerService customerService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PaymentService paymentService;
    @Autowired

    private ProductService productService;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.createCustomer(customer);

        Wallet wallet = new Wallet();
        wallet.setCustomer(savedCustomer);
        wallet.setCreditLimit(savedCustomer.getCreditLimit());
        wallet.setBalance(200.0);
        log.info("wallet", wallet);
         walletService.createWallet(wallet);

        return ResponseEntity.created(URI.create("/api/v1/customers/" + savedCustomer.getId())).body(savedCustomer);
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/customers/{customerId}/credit-limit")
    public ResponseEntity<Void> updateCustomerCreditLimit(@PathVariable Long customerId,
                                                          @RequestParam double newCreditLimit) {
        customerService.updateCustomerCreditLimit(customerId, newCreditLimit);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody Wallet wallet) {
        Wallet savedWallet = walletService.createWallet(wallet);
        return ResponseEntity.created(URI.create("/api/v1/wallets/" + savedWallet.getId())).body(savedWallet);
    }

    @PutMapping("/wallets/{walletId}")
    public ResponseEntity<Void> updateWallet(@PathVariable Long walletId, @RequestBody Wallet wallet) {
        wallet.setId(walletId);
        walletService.updateWallet(wallet);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/wallets/{customerId}")
    public Wallet getWalletByCustomer(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return walletService.getWalletByCustomer(customer);
    }



    @PostMapping("/purchases")
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {

        walletService.resetCreditLimit();
        log.info("this is purchase: {}",purchase);
       Customer customer = customerService.getCustomerById(purchase.getCustomer().getId());
        Wallet wallet = walletService.getWalletByCustomer(customer);
        log.info("this is purchase : {}",purchase);
       //BigDecimal totalAmount = purchase.getProduct().getPrice()(BigDecimal.valueOf(purchase.getQuantity())).multiply();

        Product product = productService.getProductById((purchase.getProduct().getId()));
        log.info("this is price : {}",purchase.getProduct().getId());
        log.info("this is quantity : {}",purchase.getQuantity());
       Double totalAmount = (double) (product.getPrice() * (purchase.getQuantity()));
       log.info("amount: {}", totalAmount);
    log.info("some err : {}",wallet);
        BigDecimal total = BigDecimal.valueOf(totalAmount);
        //if ((wallet.getBalance() + (totalAmount)).compareTo(wallet.getCreditLimit()) > 0) {
        if ((wallet.getBalance()<(totalAmount)) ){


            throw new IllegalArgumentException("Exceeded credit limit");
        }
        // wallet.setBalance(wallet.getBalance().add(totalAmount));
        wallet.setBalance(wallet.getBalance() -totalAmount);
        walletService.updateWallet(wallet);
       purchase.setProduct(productService.getProductById(product.getId()));
       // Product fjfj;
        log.info("purchased product id : {}",purchase.getProduct());
      // (Product) fjfj = purchase.getProduct().getId();
      // purchase.setProduct(fjfj);


         purchaseService.createPurchase(purchase);
        return ResponseEntity.created(URI.create("/api/v1/wallets/ " + purchase.getCustomer())).body(purchase);
        //return ResponseEntity<Purchase>("jjj",HttpStatus.BAD_REQUEST);


    }
        //product

        @PostMapping("/product")
        public ResponseEntity<Product> createProduct(@RequestBody Product product) {
            Product createdProduct = productService.createProduct(product);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        }

        @GetMapping("/allproducts")
        public ResponseEntity<List<Product>> getAllProducts() {
            List<Product> products = productService.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
            Product product = productService.getProductById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }

    }
