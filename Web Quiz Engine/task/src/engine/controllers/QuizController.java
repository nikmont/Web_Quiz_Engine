package engine.controllers;

import engine.dto.QuizCardDTO;
import engine.model.Answer;
import engine.model.QuizCard;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import engine.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @RequestMapping(value = "/quizzes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QuizCardDTO>> getAll() {
        List<QuizCardDTO> quizCards = quizService.getCards();

        if (quizCards.isEmpty()) {
            return new ResponseEntity<>(quizCards, HttpStatus.OK);
        }

        return new ResponseEntity<>(quizCards, HttpStatus.OK);
    }

    @RequestMapping(value = "/quizzes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuizCardDTO> getQuizById(@PathVariable("id") int id) {
        QuizCardDTO card;

        try {
            card = quizService.getCard(id);
        } catch (IndexOutOfBoundsException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (card == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @RequestMapping(value = "/quizzes/{id}/solve", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Answer> solveQuizCard(@RequestParam int answer, @PathVariable("id") int id) {

        QuizCardDTO card = quizService.getCard(id);
        Answer result = new Answer();

        if (card == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (true/*card.getAnswer() != answer*/) {
            result.setSuccess(false);
            result.setFeedback("Wrong answer! Please, try again.");
        } else {
            result.setSuccess(true);
            result.setFeedback("Congratulations, you're right!");
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/quizzes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuizCardDTO> addQuizCard(@RequestBody @Valid QuizCard quiz) {

        if (quiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        quizService.add(quiz);

        return new ResponseEntity<>(quizService.getLatsCard(), HttpStatus.OK); //add id to json resp
    }
}
