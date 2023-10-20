package Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;


public class ExtentReport {
	
	public static ExtentReports getreport() {
		
		ExtentReports report = new ExtentReports();
		ExtentSparkReporter spark =new ExtentSparkReporter("C:\\Users\\Akash Gowda\\Documents\\RestAssuredFinal\\target\\report.html");
		report.attachReporter(spark);
		spark.config().setReportName("Rest Assured Project");
		report.setSystemInfo("Tester", "Akash,Nikitha,Diya,Krishna");
		return report;
		
	}
	



}
