package store.com.retail_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.com.retail_store.model.Vendor;

import java.util.Optional;



public interface VendorRepository extends JpaRepository<Vendor,Long> {



    Optional <Vendor> findByID(Long id);

}
