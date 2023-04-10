package store.com.retail_store.serviceImp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.com.retail_store.model.Customer;
import store.com.retail_store.model.Product;
import store.com.retail_store.model.Purchase;
import store.com.retail_store.model.Wallet;
import store.com.retail_store.repository.PurchaseRepository;
import store.com.retail_store.service.CustomerService;
import store.com.retail_store.service.ProductService;
import store.com.retail_store.service.PurchaseService;
import store.com.retail_store.service.WalletService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
    @Service
    public class PurchaseServiceImp implements PurchaseService {

        @Autowired
        private PurchaseRepository purchaseRepository;
        @Autowired
        private WalletService walletService;
        @Autowired
        private CustomerService customerService;
        @Autowired
        private ProductService productService;
        @Override
        public Purchase createPurchase(Purchase purchase) {
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

            LocalDate now = LocalDate.now();
            int year = now.getYear();
            int month = now.getMonthValue();
                 purchase.setYear(year);
                 purchase.setMonth(month);

             purchaseRepository.save(purchase);
            return purchase;
        }

        @Override
        public List<Purchase> getAllPurchases() {
            return purchaseRepository.findAll();
        }

        @Override
        public List<Purchase> getMonthlyReport() {
            // get current month and year
            LocalDate now = LocalDate.now();
            int year = now.getYear();
            int month = now.getMonthValue();

            return purchaseRepository.findByYearAndMonth(year, month);
        }

    }
