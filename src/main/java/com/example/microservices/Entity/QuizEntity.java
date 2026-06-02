package com.example.microservices.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToMany
    private List<QuesttionEntity> question;
}
