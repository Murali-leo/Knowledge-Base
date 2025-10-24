package main.java.paymentenum;

public enum PaymentStatus {
    
    SUCCESS(200, "Payment completed successfully"),
    PENDING(102, "Payment is pending"),
    FAILED(400, "Payment failed"),
    CANCELLED(499, "Payment was cancelled"),
    RETRY;

    private final int code;
    private final String message;

    private PaymentStatus() {
        this.code = 0;
        this.message = "No additional information";
    }

    private PaymentStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
