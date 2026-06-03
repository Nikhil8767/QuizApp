package com.example.microservices.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToMany
    private List<QuesttionEntity> question;

    @ManyToOne
    @JoinColumn(name="quiz")
    private UserEntity user;
}
