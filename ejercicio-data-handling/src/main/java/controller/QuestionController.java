package controller;

import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.QuestionService;

import java.util.List;


@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{askCount}")
    public ResponseEntity<List<Question>> getAskCount(@PathVariable String id) {
        List<Question> questions = questionService.findNeverAskedQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/ById/{id}")
    public ResponseEntity<Question> findQuestionById(@PathVariable String id) {
        Question question = questionService.findQuestionById(id);
        if(question != null) {
            return ResponseEntity.ok(question);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
