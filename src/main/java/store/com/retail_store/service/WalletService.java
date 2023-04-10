package store.com.retail_store.service;

import store.com.retail_store.model.Customer;
import store.com.retail_store.model.Wallet;

public interface WalletService {

    Wallet createWallet(Wallet wallet);
    void updateWallet(Wallet wallet);
    Wallet getWalletByCustomer(Customer customer);
    void resetCreditLimit();

}


