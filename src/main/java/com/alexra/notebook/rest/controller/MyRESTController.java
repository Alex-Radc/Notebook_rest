package com.alexra.notebook.rest.controller;

import com.alexra.notebook.rest.entity.User;
import com.alexra.notebook.rest.exeption_handling.NoSuchUserException;
import com.alexra.notebook.rest.exeption_handling.UserIncorrectData;
import com.alexra.notebook.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

//    public  static final Logger LOGGER = Logger.getLogger(MyRESTController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public  List<User> showAllUsers(){
        List<User>  allUsers = userService.getAllUsers();
        return allUsers;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        User user = userService.getUser(id);
        if( user == null ){
           throw  new NoSuchUserException("There is no users with id = "+id + " in Database");
        }
        return user;
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        User user = userService.getUser(id);
        if(user == null){
            throw new NoSuchUserException("There is no user with ID = " +id+ " in Database");
        }
        userService.deleteUser(id);
        return "User with ID = "+ id +" was deleted";
    }



}
