package store.com.retail_store.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {


@Id

@GeneratedValue(strategy = GenerationType.SEQUENCE)
   @JsonProperty
private  Long Id;
    private  String name;
    private String address;
    private  String phoneNumber;
    private  String email;
    private  double creditLimit;

   // customerId: String
  //  name: String
  //  walletBalance: double
 //   creditLimit: double


}
