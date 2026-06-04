package com.example.microservices.Service;

import com.example.microservices.Entity.UserEntity;
import com.example.microservices.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
      private UserRepository urs;

    public ResponseEntity<List<UserEntity>>getAllUser(){
        return new ResponseEntity<>(urs.findAll(), HttpStatus.OK);

    }

    public ResponseEntity<String>createUser(UserEntity user){
        UserEntity a=new UserEntity();
        a.setUsername(user.getUsername());
        a.setPassword(user.getPassword());
        a.setRole(user.getRole());
        urs.save(a);

        return new ResponseEntity<>("user created successully",HttpStatus.OK);
    }
}
