package com.learning.quiz_service.feign;

import com.learning.quiz_service.model.Question;
import com.learning.quiz_service.model.QuestionWrapper;
import com.learning.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {


        @GetMapping("/question/allQuestions")
        ResponseEntity<List<Question>> getAllQuestions();

        @GetMapping("/question/category/{category}")
        ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("category") String category);

        @PostMapping("/question/add")
        ResponseEntity<String> addQuestion(@RequestBody Question question);

        @GetMapping("/question/generate")
        ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam("category") String category,
                                                         @RequestParam("numQ") Integer numQ);

        @PostMapping("/question/getQuestion")
        ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionsIds);

        @PostMapping("/question/getScore")
        ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);


}
