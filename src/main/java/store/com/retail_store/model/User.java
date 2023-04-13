package store.com.retail_store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
   private Long  user_ID ;






  // @OneToOne
  // @JoinColumn(name = "vendor_id")
   private  Long vendor ;
    private String Username;
    private String password;

    private String email;

    private String firstname;
    private String lastname;


}
