package Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


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
