package engine.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class QuizCard {

    @NotBlank(message = "Title should not be empty")
    private String title;
    @NotBlank(message = "Text should not be empty")
    private String text;
    @Size(min = 2, message = "Minimum number of options is 2")
    @NotNull
    private List<String> options;
    private List<Integer> answer;

    public QuizCard() {
    }

    public QuizCard(String title, String text, List<String> options, List<Integer> answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
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

    @Override
    public String toString() {
        return "QuizCard{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", options=" + options +
                ", answer=" + answer +
                '}';
    }
}
