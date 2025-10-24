package main.java.paymentenum;

public class PaymentStatusTest {
    public static void main(String[] args) {
        for(PaymentStatus status : PaymentStatus.values()) {
            System.out.println("Status: " + status + ", Code: " + status.getCode() + ", Message: " + status.getMessage());
        }
    }
}
