package main.java.paymentenum;

public enum Premium {
    LIFE{
        @Override
        public double calculatePremium(double amount) {
            return amount * 1.1; // 5% premium for life insurance
        }
    },
    HEALTH{
        @Override
        public double calculatePremium(double amount) {
            return amount * 1.2; // 3% premium for health insurance
        }
    }, 
    VEHICLE{
        @Override
        public double calculatePremium(double amount) {
            return amount * 1.15; // 4% premium for vehicle insurance
        }
    };
    public abstract double calculatePremium(double amount);
}

