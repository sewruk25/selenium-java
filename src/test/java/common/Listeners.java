package common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {


    public void onTestStart(ITestResult result) {
        System.out.println("Test case is starting ");
    }


    public void onTestSuccess(ITestResult result) {
    }


    public void onTestFailure(ITestResult result) {
    }


    public void onTestSkipped(ITestResult result) {
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }


    public void onTestFailedWithTimeout(ITestResult result) {
    }


    public void onStart(ITestContext context) {
    }


    public void onFinish(ITestContext context) {
    }
}
