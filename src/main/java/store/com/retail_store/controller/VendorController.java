package store.com.retail_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.com.retail_store.model.Vendor;
import store.com.retail_store.service.VendorService;

@RestController
@RequestMapping("/vendor/v1")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @PostMapping("/createvendor")
    public  String createVendor(@RequestBody Vendor vendor){

       return vendorService.createVendor(vendor);

       // return "ddd";
    }


}
