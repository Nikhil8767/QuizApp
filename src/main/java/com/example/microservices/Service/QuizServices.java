package com.example.microservices.Service;

import com.example.microservices.Entity.QuizEntity;
import com.example.microservices.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServices {

    @Autowired
    private QuizRepository qrs;

    public ResponseEntity<List<QuizEntity>>getAllQuiz(){
        return new ResponseEntity<>(qrs.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<String>createQuiz(QuizEntity quiz){
         QuizEntity a=new QuizEntity();
         a.setUser(quiz.getUser());
         a.setTitle(quiz.getTitle());
         a.setQuestion(quiz.getQuestion());

         qrs.save(a);
         return new ResponseEntity<>("quiz created successfully",HttpStatus.OK);
    }

}
