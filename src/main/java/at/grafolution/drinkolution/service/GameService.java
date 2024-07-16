package at.grafolution.drinkolution.service;


import at.grafolution.drinkolution.model.Game;
import at.grafolution.drinkolution.model.Player;
import at.grafolution.drinkolution.model.Question;
import at.grafolution.drinkolution.model.Quiz;
import at.grafolution.drinkolution.repository.GameRepository;
import at.grafolution.drinkolution.repository.PlayerRepository;
import at.grafolution.drinkolution.repository.QuestionRepository;
import at.grafolution.drinkolution.repository.QuizRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public Quiz addQuiz(Quiz quiz) {
        quiz.setActive(true);  // Mark the quiz as active when created
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    @Transactional
    public Quiz addPlayerToQuiz(Long quizId, Player player) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        if (optionalQuiz.isPresent()) {
            Quiz quiz = optionalQuiz.get();
            player.setQuiz(quiz);
            playerRepository.save(player);
            quiz.getPlayers().add(player);
            return quizRepository.save(quiz);
        }
        return null;
    }



    @Transactional
    public void endQuiz(Long quizId) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        if (optionalQuiz.isPresent()) {
            Quiz quiz = optionalQuiz.get();
            quiz.setActive(false);
            quizRepository.save(quiz);
        }
    }
}