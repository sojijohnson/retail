package store.com.retail_store.service;

import store.com.retail_store.model.Purchase;

import java.util.List;

public interface PurchaseService {

    Purchase createPurchase(Purchase purchase);
    List<Purchase> getAllPurchases();
    List<Purchase> getMonthlyReport();
}
