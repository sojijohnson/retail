package store.com.retail_store.repository;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import store.com.retail_store.customer.Purchase;

import java.util.List;




public interface PurchaseRepository extends JpaRepository<Purchase, Long> {



    List<Purchase> findByYearAndMonth(int year, int month);
}
