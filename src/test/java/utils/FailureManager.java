package utils;

public class FailureManager {

    private static int failureCount = 0;

    private FailureManager() {
    }

    public static void reset() {

        failureCount = 0;
    }

    public static void recordFailure() {

        failureCount++;
    }

    public static int getFailureCount() {

        return failureCount;
    }

    public static boolean shouldStopExecution() {

        return failureCount
                >= ConfigReader.getFailureThreshold();
    }
}