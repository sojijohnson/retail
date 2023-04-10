package store.com.retail_store.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.com.retail_store.model.User;
import store.com.retail_store.service.UserService;

@RestController
@RequestMapping("/user/v1")
public class UserController {


    @PostMapping("/createuser")
    public String createUser(@RequestBody User user){
        UserService.createUser(user);
        return "created";
    }


}
