package store.com.retail_store.model;

import jakarta.persistence.*;
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
        @ManyToOne
        @JoinColumn(name = "vendor_vendor_id")
        private Vendor vendor;

        // constructor, getters, and setters


}
