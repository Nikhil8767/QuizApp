package com.example.microservices.Controller;

import com.example.microservices.Entity.UserEntity;
import com.example.microservices.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService urs;

    @GetMapping("/allUsers")
        public ResponseEntity<List<UserEntity>>getAllUser(){
        return urs.getAllUser();
    }

    @PostMapping("/addUser")
    public ResponseEntity<String>createUser(@RequestBody UserEntity  user){
        return urs.createUser(user);
    }

}
