package at.grafolution.drinkolution.service;

import at.grafolution.drinkolution.model.Question;
import at.grafolution.drinkolution.model.Quiz;
import at.grafolution.drinkolution.repository.QuestionRepository;
import at.grafolution.drinkolution.repository.QuizRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;
    @Transactional
    public Question getRandomQuestion(String category) {
        Optional<Question> optionalQuestion;
        if (category == null) {
            optionalQuestion = questionRepository.findRandomUnaskedQuestion();
        } else {
            optionalQuestion = questionRepository.findRandomUnaskedQuestionByCategory(category);
        }

        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            question.setAsked(true);
            questionRepository.save(question);
            return question;
        } else {
            // Reset all questions to unasked if all have been asked
            questionRepository.resetAllQuestions();
            return getRandomQuestion(category);
        }
    }

    @Transactional
    public List<Question> getQuestionsByCategory(Long quizId, String category) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        if (optionalQuiz.isPresent() && optionalQuiz.get().isActive()) {
            return questionRepository.findByCategory(category);
        }
        return new ArrayList<>(0);
    }
}