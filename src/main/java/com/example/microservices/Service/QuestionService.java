package com.example.microservices.Service;

import com.example.microservices.Entity.QuesttionEntity;
import com.example.microservices.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {


    @Autowired
    private QuestionRepository qrs;
    public ResponseEntity<List<QuesttionEntity>>getAllQuestion(){
        return new ResponseEntity<>(qrs.findAll(), HttpStatus.OK);
    }


}
