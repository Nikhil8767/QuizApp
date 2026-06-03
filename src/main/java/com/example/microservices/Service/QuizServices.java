package com.example.microservices.Service;

import com.example.microservices.Entity.QuizEntity;
import com.example.microservices.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServices {

    @Autowired
    private QuizRepository qrs;

public org.springframework.http.ResponseEntity<?> getAllQuiz(int id){
    Optional<QuizEntity> a=qrs.findById(id);
    if(a.isEmpty()){
        return new org.springframework.http.ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
    }
    else{
        return new ResponseEntity<>(a.get(),HttpStatus.OK);
    }
}




}
