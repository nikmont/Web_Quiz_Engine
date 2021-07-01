package engine.model;

public class Answer {

    private String feedback;
    private boolean success;

    public Answer(String feedback, boolean success) {
        this.feedback = feedback;
        this.success = success;
    }

    public Answer() {
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
