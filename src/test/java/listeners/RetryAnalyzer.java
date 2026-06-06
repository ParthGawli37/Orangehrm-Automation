package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.ConfigReader;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;

    private final int maxRetry =
            Integer.parseInt(
                    ConfigReader.getProperty("retry.count")
            );

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxRetry) {

            count++;

            return true;
        }

        return false;
    }
}