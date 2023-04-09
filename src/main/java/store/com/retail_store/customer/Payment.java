package store.com.retail_store.customer;
//customer, amount, and date.

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Payment {

    @Id
     private Long Id;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private  double amount;
    private Date date;
    private int year;
    private  int month;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
