package com.example.microservices.Repository;

import com.example.microservices.Entity.QuesttionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuesttionEntity,Integer> {
}
