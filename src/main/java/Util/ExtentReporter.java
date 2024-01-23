package Util;

import Base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReporter extends TestBase {


    public static ExtentReports generateExtentReports(){

        ExtentReports extentReports = new ExtentReports();
        File extentReportsFile = new File(System.getProperty("user.dir")+"/src/main/java/Report/extentReports.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportsFile);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("GajiGesa UI-Automation Report");
        sparkReporter.config().setDocumentTitle("GajiGesa UI-Automation Report");
        sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Application URL", prop.getProperty("URL"));
        extentReports.setSystemInfo("Browser Name", prop.getProperty("Browser"));
       return  extentReports;
s


    }
}
