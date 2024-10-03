package utilites;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import BaseClasses.BaseClass;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExtentReport extends TestListenerAdapter {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports reports;
    public ExtentTest test;
    public String reportName;

    @Override
    public void onStart(ITestContext testContext) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MMM-dd_HH-mm-ss"));
        reportName = "Test_Report_" + dateTime + ".html";
        sparkReporter=new ExtentSparkReporter("D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\reports\\"+reportName);
        sparkReporter.config().setReportName("Dhamotharan");
        sparkReporter.config().setDocumentTitle("Open Card Testing");
        sparkReporter.config().setTheme(Theme.DARK);
        reports =new ExtentReports();
        reports.attachReporter(sparkReporter);
        reports.setSystemInfo("Application","Open Card");
        reports.setSystemInfo("Operating System", System.getProperty("os.name"));
        reports.setSystemInfo("Java Version", System.getProperty("java.version"));
        reports.setSystemInfo("Browser", "Chrome");
        List<String> includedGroups =testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()){
            reports.setSystemInfo("Included Groups",includedGroups.toString());
        }
        List<String> excludedGroups =testContext.getCurrentXmlTest().getIncludedGroups();
        if (!excludedGroups.isEmpty()){
            reports.setSystemInfo("Excluded Groups",excludedGroups.toString());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
        String path="D:\\java files\\selinium\\Selenium _intellij_IDE\\OpenCart\\reports\\"+reportName;
        File extentReport =new File(path);
        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test=reports.createTest(result.getClass().getName());//Display the Class name
        test.assignCategory(result.getMethod().getGroups());// to display group of the test method
        test.log(Status.PASS,result.getName()+" got successfully completed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test=reports.createTest(result.getClass().getName());
        test.assignCategory(result.getMethod().getGroups());// to display the in which group that test method
        test.log(Status.FAIL,result.getName()+" got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());// error of the test
        try {
            String imagePath=new BaseClass().ScreenShotCapture(result.getClass().getName());
            test.addScreenCaptureFromPath(imagePath);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test=reports.createTest(result.getClass().getName());
        test.assignCategory(result.getMethod().getGroups());// to display the in which group that test method
        test.log(Status.SKIP,result.getName()+" got skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }
}
