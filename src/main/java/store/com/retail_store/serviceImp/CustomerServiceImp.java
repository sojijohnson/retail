package store.com.retail_store.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.com.retail_store.model.Customer;
import store.com.retail_store.model.Wallet;
import store.com.retail_store.repository.CustomerRepository;
import store.com.retail_store.service.CustomerService;
import store.com.retail_store.service.WalletService;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {



        @Autowired
        private CustomerRepository customerRepository;

        @Autowired
        private WalletService walletService;

        @Override
        public Customer createCustomer(Customer customer) {
            return customerRepository.save(customer);
        }



    @Override
        public Customer getCustomerById(Long id) {
            return customerRepository.findById(id).orElse(null);
        }

        @Override
        public List<Customer> getAllCustomers() {
            return customerRepository.findAll();
        }

        @Override
        public void updateCustomerCreditLimit(Long customerId, double newCreditLimit) {
            Customer customer = customerRepository.findById(customerId).orElse(null);
            if (customer == null) {
                throw new RuntimeException("Customer not found with id " + customerId);
            }

            Wallet wallet = walletService.getWalletByCustomer(customer);
            if (wallet == null) {
                throw new RuntimeException("Wallet not found for customer with id " + customerId);
            }

            wallet.setCreditLimit(newCreditLimit);
            walletService.updateWallet(wallet);
        }

}
