package com.mini.fb.minifb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepo userRepo;


    //Save a user into db
    @RequestMapping(value = "/signUp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void signUp(@RequestBody UserModel userModel) {
        userRepo.save(userModel);
    }

    //Get all users from db
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<UserModel> getAllUsers() {
        return userRepo.findAll();
    }

    //Get user from db
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserModel getUserById(@RequestParam(name = "id") int id) {
        return userRepo.getUserById(id);
    }

    //Delete user from db
//    @RequestMapping(value = "/deleteUserById/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public long deleteUserById(@PathVariable int id) {
//        return userRepo.deleteUserById(id);
//    }
    //Delete user from db (another way)
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteUserById(@RequestBody UserModel userModel) {
        userRepo.delete(userModel);
    }
}
