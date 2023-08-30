package repository;

import model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, String> {
    int getAskCount();
    List<Question> findAll();
    List<Question> findNeverAskedQuestions();
    Optional<Question> findQuestionById(String id);
}
