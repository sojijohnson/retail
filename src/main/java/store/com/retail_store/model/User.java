package store.com.retail_store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
   private String  user_ID ;

   @ManyToOne
   @JoinColumn(name = "vendor_id_vendor_id")
   private  Vendor vendor_Id ;
    private String Username;
    private String password;

    private String email;

    private String firstname;
    private String lastname;


}
