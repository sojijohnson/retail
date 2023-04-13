package store.com.retail_store.serviceImp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.com.retail_store.model.User;
import store.com.retail_store.model.Vendor;
import store.com.retail_store.repository.UserRepository;
import store.com.retail_store.repository.VendorRepository;
import store.com.retail_store.service.UserService;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImp implements UserService {
//@Autowired
//private   Vendor vendor;
@Autowired
   private  UserRepository userRepository;

@Autowired
private  VendorRepository vendorRepository;

       Vendor vendor = new Vendor();
    @Override
    public String createUser(User user) {

       Vendor vendor = new Vendor();
    log.info("this is the user: {}", user);
     //  User email = userRepository.findByEmail(user.getEmail());


        Long userId = user.getVendor();

        // Optional<Vendor> id= vendorRepository.findById(userId);

        Boolean yes=  vendorRepository.existsById(userId);
        //Vendor  id= vendorRepository.findById(userId);
        log.info("this is the userID: {}", userId);
        //  log.info("this is the vendorID: {}", id);
        // Vendor vendorid = id.orElse(null);

        // log.info("this is the vendorID: {}", vendorid);
        //if (vendorid.equals(user.getVendor())){

        if (yes){
            userRepository.save(user);
        }else{
            log.info("Vendor Id does not exists");
            return "Vendor Id does not exists";
        }

//       if (Objects.isNull(id)){
//           //vendor.setID(user.getVendor().getID());
//           log.info("vendor Id {}", vendor);
//           user.setVendor(vendor);
//         //  Vendor vendor22 =new Vendor();
//          // vendor22.setVendor_Address("eeeee");
//          // vendor22.setVendor_Phone("ddddd");
//         // vendor22.setVendor_Number(7L);
//         //  vendor22.setID(1l);
//          // vendorRepository.save(vendor22);
//
//
//           return "userAdded";
//       }
        log.info("user added");
        return  "user added";
    }


   public static Vendor createVendor(Vendor vendor){

     //   Vendor vendor1 = Vendor.builder().vendor_Address("weerr").vendor_Phone("456777").vendor_Name("tomso")
         //         .build();
       // Vendor vendor1 = new Vendor();
        vendor.setVendor_Name("aaa");
        vendor.setVendor_Address("bbb");
        vendor.setVendor_Phone("12345");
        vendor.setVendor_Name("tomso");
    //    vendor1.setID();
        return  vendor;

        //vendor1.
    }

}

