package engine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import engine.model.QuizCard;

import java.util.List;

public class QuizCardDTO {

    private int id;
    private String title;
    private String text;
    private List<String> options;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> answer;


    public QuizCardDTO(QuizCard card, int index) {
        this.text = card.getText();
        this.title = card.getTitle();
        this.options = card.getOptions();
        this.answer = card.getAnswer();
        this.id = index;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
}
