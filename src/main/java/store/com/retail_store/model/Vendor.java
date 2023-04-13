package store.com.retail_store.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Vendor {


@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private  Long vendor_Number;

//should be LOng
 private Long   ID;

   private String vendor_Name;
    private String vendor_Address;
    private  String  vendor_Phone;
}
