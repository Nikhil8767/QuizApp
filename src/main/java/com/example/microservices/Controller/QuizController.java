package com.example.microservices.Controller;

import com.example.microservices.Entity.QuizEntity;
import com.example.microservices.Repository.QuizRepository;
import com.example.microservices.Service.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    private QuizServices qrs;
    @GetMapping("/AllQuiz")
    public ResponseEntity<List<QuizEntity>>Allqui(){
        return qrs.getAllQuiz();
    }

    @PostMapping("/createQuiz")
    public ResponseEntity<String>createQuiz(@RequestBody QuizEntity quiz){

        return qrs.createQuiz(quiz);



    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<?>getQuiz(@PathVariable int id){
        return qrs.getQuiz(id);
    }
}
