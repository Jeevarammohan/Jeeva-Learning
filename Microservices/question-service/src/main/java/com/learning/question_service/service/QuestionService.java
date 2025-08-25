package com.learning.question_service.service;

import com.learning.question_service.dao.QuestionDao;
import com.learning.question_service.model.Question;
import com.learning.question_service.model.QuestionWrapper;
import com.learning.question_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_GATEWAY);
        }

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category){
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_GATEWAY);
        }
    }

    public ResponseEntity<String> addQuestion(Question question){
        questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> getQuestionForQuiz(String category,Integer numQ){

        return new ResponseEntity<>(questionDao.findRandomQuestionByQuestion(category,numQ),HttpStatus.OK);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionsIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = questionDao.findAllById(questionsIds);
        for(Question question : questions){
            QuestionWrapper questionWrapper = new QuestionWrapper();
            questionWrapper.setId(question.getId());
            questionWrapper.setQuestionTitle(question.getQuestionTitle());
            questionWrapper.setOption1(question.getOption1());
            questionWrapper.setOption2(question.getOption2());
            questionWrapper.setOption3(question.getOption3());
            questionWrapper.setOption4(question.getOption4());
            wrappers.add(questionWrapper);
            ;
        }
        return new ResponseEntity<>(wrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        Integer right=0;
        for(Response response : responses){
            Optional<Question> question = questionDao.findById(response.getId());
            if(question.isPresent() && question.get().getRightAnswer().equalsIgnoreCase(response.getResponse())){
                right++;
            }
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
