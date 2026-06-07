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

    public ResponseEntity<String>addQuestion(QuesttionEntity question){
        QuesttionEntity a=new QuesttionEntity();
        a.setQuestion(question.getQuestion());
        a.setCategory(question.getCategory());
        a.setAnswer(question.getAnswer());
        a.setDifficultyLevel(question.getDifficultyLevel());
        a.setOption1(question.getOption1());
        a.setOption2(question.getOption2());
        a.setOption3(question.getOption3());
        a.setOption4(question.getOption4());

        qrs.save(a);

        return new ResponseEntity<>("question added",HttpStatus.OK);
    }


}
