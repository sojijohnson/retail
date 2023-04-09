package store.com.retail_store.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
@Entity
  // @NamedQuery(name="Purchase.findByYearAndMonth" , query="SELECT * FROM purchase WHERE YEAR(date) = :year AND MONTH(date) = :month")
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Purchase implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;
    private String purchaseId;
    @OneToOne
    @JoinColumn(name = "customer_id")
    @JsonProperty
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "id")
    private Product product;
    @UpdateTimestamp
    private Date purchaseDate ;
    private int quantity;
//@CreatedDate
    private int year;

//@CreatedDate
    private  int month;



    //Calendar calendar= getCalendar().
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

}
