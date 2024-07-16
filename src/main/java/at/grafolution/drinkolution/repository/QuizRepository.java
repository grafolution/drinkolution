package at.grafolution.drinkolution.repository;

import at.grafolution.drinkolution.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
