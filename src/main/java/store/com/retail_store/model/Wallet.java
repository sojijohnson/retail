package store.com.retail_store.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Wallet {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    //customer, balance, and credit limit.
     private Long Id;
    @OneToOne
    private Customer customer;
    private  double balance;
    private  double creditLimit;

//    public void setCreditLimit(double i) {
//    }
}
