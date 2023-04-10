package store.com.retail_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.com.retail_store.model.Customer;
import store.com.retail_store.model.Wallet;




public interface WalletRepository extends JpaRepository<Wallet,Long> {


    Wallet findByCustomer(Customer customer);
}
