package com.mini.fb.minifb;


import org.springframework.beans.factory.annotation.Autowired;
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
    public CustomResponse signUp(@RequestBody UserModel userModel) {

        if (userRepo.isUserExists(userModel.getEmail()) == null) {
            userRepo.save(userModel);
            return new CustomResponse("Signed Up Successfully", userModel);
        } else {
            return new CustomResponse("You 're already user, please login");
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public CustomResponse login(@RequestBody UserModel userModel) {
        if (userRepo.isUserExists(userModel.getEmail(), userModel.getPassword()) == null) {
            return new CustomResponse("Wrong email or password");
        } else {
            return new CustomResponse("Logged in successfully", userRepo.getUserByEmail(userModel.getEmail()));
        }
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
    @RequestMapping(value = "/deleteUserById/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CustomResponse deleteUserById(@PathVariable(name = "id") int id) {
        UserModel userModel = new UserModel(id);
        userRepo.delete(userModel);
        return new CustomResponse("Deleted Successfully");
    }
}
