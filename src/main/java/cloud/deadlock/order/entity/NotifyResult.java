package cloud.deadlock.order.entity;

public class NotifyResult {
    private String message;
    private boolean success;

    public NotifyResult(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
