package engine.model;

public class Result {

    private String feedback;
    private boolean success;

    public Result(boolean success) {
        this.feedback = success ? "Congratulations, you're right!" : "Wrong answer! Please, try again.";
        this.success = success;
    }

    public Result() {
    }

    public String getFeedback() {
        return feedback;
    }

    public boolean isSuccess() {
        return success;
    }
}
