package store.com.retail_store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
         private Long Id;
       // private String productId;
        private String name;
        private double price;

        // constructor, getters, and setters


}
