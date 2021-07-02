package engine.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Еhere is no such id")
public class WrongQuizIdException extends RuntimeException {
}
