package com.example.microservices.Controller;

import com.example.microservices.Entity.QuesttionEntity;
import com.example.microservices.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

@PostMapping("/addQuestion")
    public ResponseEntity<String>addQuestion(@RequestBody QuesttionEntity questtion){
    return qrs.addQuestion(questtion);
}
}
