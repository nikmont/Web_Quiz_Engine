package engine.service;

import engine.dto.AnswerDTO;
import engine.dto.QuizCardDTO;
import engine.exceptions.WrongQuizIdException;
import engine.model.QuizCard;
import engine.repos.QuizCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private QuizCardRepository repository;

    @Autowired
    public QuizService(QuizCardRepository repository) {
        this.repository = repository;
    }

    public List<QuizCardDTO> getAll() {
        return repository.findAll().stream()
                        .map(q -> new QuizCardDTO(q, q.getId()))
                        .collect(Collectors.toList());
    }

    public QuizCardDTO getCard(long id) {

        QuizCard quiz = repository.findById(id)
                .orElseThrow(WrongQuizIdException::new);

        return new QuizCardDTO(quiz, quiz.getId());
    }

    public QuizCardDTO add(QuizCard card) {
        QuizCard savedCard = repository.save(card);
        return new QuizCardDTO(savedCard, savedCard.getId());
    }

    public boolean checkAnswer(AnswerDTO answer, int id) {

        //if (id > quizCards.size()) throw new IndexOutOfBoundsException();

        List<Integer> correctAnswers = getCard(id).getAnswer();

        List<Integer> incomeAnswers = answer.getAnswer();

//        System.out.println("Answers from DB: " + correctAnswers);
//        System.out.println("Answers from Request: " + incomeAnswers);
//        System.out.println(incomeAnswers.equals(correctAnswers));

        return incomeAnswers.equals(correctAnswers);
    }

}
