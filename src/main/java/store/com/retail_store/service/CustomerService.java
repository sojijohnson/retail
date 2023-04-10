package store.com.retail_store.service;

import store.com.retail_store.model.Customer;

import java.util.List;

public interface CustomerService {

        Customer createCustomer(Customer customer);
        Customer getCustomerById(Long id);
        List<Customer> getAllCustomers();
        void updateCustomerCreditLimit(Long customerId, double newCreditLimit);
    }

