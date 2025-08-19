package com.learning.question_service.dao;

import com.learning.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);


    @Query(value = "SELECT * FROM question WHERE category=:category ORDER BY RANDOM() LIMIT :numQ")
    List<Question> findRandomQuestionByQuestion(String category,int numQ);
}
