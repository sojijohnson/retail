package store.com.retail_store.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.com.retail_store.model.Vendor;
import store.com.retail_store.repository.VendorRepository;
import store.com.retail_store.service.VendorService;


@Service
public class VendorServiceImp implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;
    @Override
    public String createVendor(Vendor vendor) {

        vendorRepository.save(vendor);

        return "user saved";
    }


    // public User createUser()

}
