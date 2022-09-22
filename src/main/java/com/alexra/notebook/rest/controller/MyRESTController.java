package com.alexra.notebook.rest.controller;

import com.alexra.notebook.rest.entity.User;
import com.alexra.notebook.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return user;
    }

}
