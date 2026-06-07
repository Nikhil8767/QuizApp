package com.example.microservices.Service;

import com.example.microservices.Entity.QuesttionEntity;
import com.example.microservices.Entity.QuizEntity;
import com.example.microservices.Repository.QuestionRepository;
import com.example.microservices.Repository.QuizRepository;
import com.example.microservices.dto.QuestionDTO;
import com.example.microservices.dto.QuizDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServices {

    @Autowired
    private QuizRepository qrs;

    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<List<QuizEntity>>getAllQuiz(){
        return new ResponseEntity<>(qrs.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<String>createQuiz(QuizEntity quiz){
         QuizEntity a=new QuizEntity();
         a.setUser(quiz.getUser());
         a.setTitle(quiz.getTitle());
         List<QuesttionEntity>questions=new ArrayList<>();
         for(QuesttionEntity id:quiz.getQuestion()){
             Optional<QuesttionEntity> ans=questionRepository.findById(id.getId());
             if(ans.isEmpty()){
                 return new ResponseEntity<>("question not found",HttpStatus.NOT_FOUND);
             }
             else{
                 questions.add(ans.get());
             }

         }
         a.setQuestion(questions);


         qrs.save(a);
         return new ResponseEntity<>("quiz created successfully",HttpStatus.OK);
    }

    public ResponseEntity<?>getQuiz(int id){
       Optional<QuizEntity>a= qrs.findById(id);
        List<QuesttionEntity>ques=a.get().getQuestion();
        List<QuestionDTO>questiondto=new ArrayList<>();
        QuizDTO quizdto=new QuizDTO();
        quizdto.setTitle(a.get().getTitle());
        quizdto.setUser(a.get().getUser());
        for(QuesttionEntity one:ques){




            QuestionDTO quesdto=new QuestionDTO();

            quesdto.setQuestion(one.getQuestion());
            quesdto.setOption1(one.getOption1());
            quesdto.setOption2(one.getOption2());
            quesdto.setOption3(one.getOption3());
            quesdto.setOption4(one.getOption4());
            questiondto.add(quesdto);




        }
        quizdto.setQuestions(questiondto);


       if(a.isEmpty()){
           return new ResponseEntity<>("quiz not found",HttpStatus.NOT_FOUND);
       }
       else{

           return new ResponseEntity<>(quizdto,HttpStatus.OK);
       }

    }

}
