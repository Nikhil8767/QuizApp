package com.example.microservices.Service;

import com.example.microservices.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
      private UserRepository urs;


}
