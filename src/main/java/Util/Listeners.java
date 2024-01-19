package Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;



public class Listeners implements ITestListener {
    ExtentReports extentReports;
    ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context){
         extentReports = ExtentReporter.generateExtentReports();
    }


    @Override
    public void onTestStart(ITestResult result){
        String testName = result.getName();
        extentTest =  extentReports.createTest(testName);
       extentTest.log(Status.INFO,testName+"Execution Started");
    }

    @Override
    public void onTestSuccess(ITestResult result){
        String testName = result.getName();
        extentTest.log(Status.PASS,testName+"Execution success");
    }

    @Override
    public void onTestFailure(ITestResult result){
        String testName = result.getName();
        WebDriver driver = null;
        try {
           driver =  (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String destinationPath = System.getProperty("user+dir")+"/src/main/java/screenShot"+testName+".png";
        try {
            FileHandler.copy(srcScreenshot,new File(destinationPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.addScreenCaptureFromPath(destinationPath);
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.FAIL,testName+"got Failed");

    }


    @Override
    public void onTestSkipped(ITestResult result){
        String testName = result.getName();
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.SKIP, testName+"got skipped");
    }

    @Override
    public void onFinish(ITestContext context){
       extentReports.flush();

    }

}
