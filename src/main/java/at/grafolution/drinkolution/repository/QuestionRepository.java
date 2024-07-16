package at.grafolution.drinkolution.repository;


import at.grafolution.drinkolution.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT * FROM Question q WHERE q.category = :category AND q.asked = false ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Question> findRandomUnaskedQuestionByCategory(@Param("category") String category);

    @Query(value = "SELECT * FROM Question q WHERE q.asked = false ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Question> findRandomUnaskedQuestion();

    @Modifying
    @Query("UPDATE Question q SET q.asked = false")
    void resetAllQuestions();

    List<Question> findByCategory(String category);

}
