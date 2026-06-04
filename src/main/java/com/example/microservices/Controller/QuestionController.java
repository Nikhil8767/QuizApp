package com.example.microservices.Controller;

import com.example.microservices.Entity.QuesttionEntity;
import com.example.microservices.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService qrs;

@GetMapping("/getAllQuestion")
    public ResponseEntity<List<QuesttionEntity>>getAllQuestion(){
    return qrs.getAllQuestion();
}
}
