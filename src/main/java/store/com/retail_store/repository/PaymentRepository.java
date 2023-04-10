package store.com.retail_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.com.retail_store.model.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {


    List<Payment> findByYearAndMonth(int year, int month);
}
