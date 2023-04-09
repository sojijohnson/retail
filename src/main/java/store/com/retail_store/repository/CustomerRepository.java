package store.com.retail_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.com.retail_store.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {





}
