package main.java.paymentenum;

public class PremiumTest {
    public static void main(String[] args) {
        for(Premium premiumType : Premium.values()) {
            double amount = 1000.0;
            double calculatedPremium = premiumType.calculatePremium(amount);
            System.out.println(premiumType + " Premium on amount " + amount + " is: " + calculatedPremium);
        }
    }
}
