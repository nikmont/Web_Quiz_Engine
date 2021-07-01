package engine.service;

import engine.dto.QuizCardDTO;
import engine.model.QuizCard;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private List<QuizCard> quizCards;

    public QuizService() {
        quizCards = new ArrayList<>();
    }

    public List<QuizCardDTO> getCards() {
        return quizCards.stream()
                .map(q -> new QuizCardDTO(q, quizCards.indexOf(q) + 1)).collect(Collectors.toList());
    }

    public QuizCardDTO getCard(int id) {
        QuizCard quiz = quizCards.get(id - 1);
        return new QuizCardDTO(quiz, quizCards.indexOf(quiz) + 1);
    }

    public void add(QuizCard card) {
        this.quizCards.add(card);
    }

    public QuizCardDTO getLatsCard() {
        QuizCard quiz = quizCards.get(quizCards.size() - 1);
        return new QuizCardDTO(quiz, quizCards.indexOf(quiz) + 1);
    }
}
