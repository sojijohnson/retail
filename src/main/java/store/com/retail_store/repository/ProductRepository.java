package store.com.retail_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.com.retail_store.customer.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
