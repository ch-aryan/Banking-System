package versions.v2.presentation.console.util;

public class RetryHelper {

    private final int maxAttempts;

    private int attempts;

    public RetryHelper(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public boolean canRetry() {
        return attempts < maxAttempts;
    }

    public void recordFailure() {
        attempts++;
    }

    public void reset() {
        attempts = 0;
    }

    public int getRemainingAttempts() {
        return maxAttempts - attempts;
    }

    public boolean isLastAttempt() {
        return attempts == maxAttempts - 1;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

}