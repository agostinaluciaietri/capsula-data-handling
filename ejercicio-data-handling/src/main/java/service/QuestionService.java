package service;

import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.QuestionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // Cantidad de veces que fue preguntada una pregunta
    public int getAskCount(Question question) {
        return question.getHasBeenAsked();
    }

    // Lista de preguntas registradas que nunca fueron preguntadas
    public List<Question> findNeverAskedQuestions() {
        List<Question> allQuestions = questionRepository.findAll();
        return allQuestions.stream().filter(q -> q.getAskedCounter() == 0).collect(Collectors.toList());
    }

    public Question findQuestionById(String id) {
        return questionRepository.findById(id).orElse(null);
    }

}
