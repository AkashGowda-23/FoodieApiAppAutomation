package Automation;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.ExtentReport;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;


public class Listners  implements ITestListener{
	ExtentTest test;
	ExtentReports report=ExtentReport.getreport();

	
	public void onTestStart(ITestResult result) {
		test= report.createTest(result.getName());
		
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("this is failed test " + result.getName() + " " + result.getMethod());
		test.fail(result.getThrowable(),null);
		
		
	}
	public void onTestSuccess(ITestResult result) {
		
		
		test.log(Status.PASS,"the test is passed" );
		
		
	}
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
}
	
	




