package engine.model;

public class Result {

    private String feedback;
    private boolean success;

    public Result(String feedback, boolean success) {
        this.feedback = feedback;
        this.success = success;
    }

    public Result() {
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
