package com.abhi.user.service.UserService.controller;

import com.abhi.user.service.UserService.entities.User;
import com.abhi.user.service.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUser();

        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/getUserbyId/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User user = userService.getUserByid(id);

        return ResponseEntity.ok(user);
    }

}
