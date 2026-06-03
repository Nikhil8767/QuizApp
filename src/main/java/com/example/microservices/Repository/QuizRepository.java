package com.example.microservices.Repository;

import com.example.microservices.Entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<QuizEntity,Integer> {
}
