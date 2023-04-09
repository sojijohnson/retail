package store.com.retail_store.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.com.retail_store.customer.Purchase;
import store.com.retail_store.repository.PurchaseRepository;
import store.com.retail_store.service.PurchaseService;

import java.time.LocalDate;
import java.util.List;


    @Service
    public class PurchaseServiceImp implements PurchaseService {

        @Autowired
        private PurchaseRepository purchaseRepository;

        @Override
        public Purchase createPurchase(Purchase purchase) {

            LocalDate now = LocalDate.now();
            int year = now.getYear();
            int month = now.getMonthValue();
                 purchase.setYear(year);
                 purchase.setMonth(month);

            return purchaseRepository.save(purchase);
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
