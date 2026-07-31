package javaprepfirstscope;

public class NestedEnum {
    // Implicitly Public Static
    public enum Status {
        PENDING,
        INITIALIZING
    }

    private Status currentStatus;

    public void setStatus(Status status) {
        currentStatus = status;
    }

    public Status getStatus() {
        return currentStatus;
    }
}

