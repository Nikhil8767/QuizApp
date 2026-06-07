package com.example.microservices.dto;

import com.example.microservices.Entity.UserEntity;
import lombok.Data;

import java.util.List;

@Data
public class QuizDTO {
    private int id;
    private String title;
    private List<QuestionDTO> questions;
    private UserEntity user;
}
