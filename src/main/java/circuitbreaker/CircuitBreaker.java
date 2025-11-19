package main.java.circuitbreaker;

import java.util.function.Supplier;

public class CircuitBreaker {

    private CircuitBreakerState state = CircuitBreakerState.CLOSED;
    private int failureCount = 0;
    private int failureThreshold;
    private final long retryTimePeriod; // in milliseconds
    private long lastFailureTime = 0;

    public CircuitBreaker(int failureThreshold, long retryTimePeriod) {
        this.failureThreshold = failureThreshold;
        this.retryTimePeriod = retryTimePeriod;
    }

    public synchronized <T> T allowRequest(Supplier<T> supplier) {
        if(state == CircuitBreakerState.OPEN) {
            if(System.currentTimeMillis() - lastFailureTime > retryTimePeriod) {
                state = CircuitBreakerState.HALF_OPEN;
                failureCount = 0;
            } else {
                throw new RuntimeException("Circuit is OPEN. Request not allowed.");
            }       
        }

        try {
            T result = supplier.get();
            onSuccess();
            return result;
        } catch (Exception e) {
            onFailure();
            throw e;
        }
    }

    private void onSuccess() {
        if(state == CircuitBreakerState.HALF_OPEN) {
            state = CircuitBreakerState.CLOSED;
            failureCount = 0;
        } else if(state == CircuitBreakerState.CLOSED) {
            failureCount = 0;
        }
    }

    private void onFailure() {
       lastFailureTime = System.currentTimeMillis();

        if (state == CircuitBreakerState.HALF_OPEN) {
            state = CircuitBreakerState.OPEN;
            return;
        }

        failureCount++;

        if (failureCount >= failureThreshold) {
            state = CircuitBreakerState.OPEN;
        }
    }
    
}
