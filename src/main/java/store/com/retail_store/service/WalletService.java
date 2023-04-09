package store.com.retail_store.service;

import store.com.retail_store.customer.Customer;
import store.com.retail_store.customer.Wallet;

import java.time.LocalDate;

public interface WalletService {

    Wallet createWallet(Wallet wallet);
    void updateWallet(Wallet wallet);
    Wallet getWalletByCustomer(Customer customer);
    void resetCreditLimit();

}


