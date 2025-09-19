package Utils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements  IRetryAnalyzer {


    private int retryCount = 0;        // Number of retries already attempted
    private static final int maxRetryCount = 2; // Maximum retry attempts (you can set any number)

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test: " + result.getName() +
                    " | Attempt " + (retryCount + 1));
            return true;  // Retry test
        }
        return false;  // Stop retrying
    }
}
