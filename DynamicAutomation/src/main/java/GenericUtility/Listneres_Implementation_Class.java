package GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listneres_Implementation_Class  implements ITestListener{

	ExtentReports report ;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
	//Step3:create the a test method during the test execution starts
		test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		
		//Step4: log the pass method
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		//step6: log fail method, take screen shot, attach screen shot to extent report
		
			test.log(Status.FAIL,  result.getMethod().getMethodName());
			test.log(Status.FAIL, result.getThrowable());
			String path=null;
		try {
			path=new WebDriverUtility().takeScreenshot(BaseClass.sdriver,  result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
		
	}

	public void onTestSkipped(ITestResult result) {
		//Step5:log the skipped method and (test case name and exception log)
		
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	

	public void onStart(ITestContext context) {
		
		//Step1: extent report configuration
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./target/extentReport"+new JavaUtility().getSystemDateAnadTime().replace(":", "-"));
		htmlreport.config().setDocumentTitle("com cast automation execution report");
		htmlreport.config().setReportName("regression execution report");
		htmlreport.config().setTheme(Theme.STANDARD);
		
		
		//Step2: Attached the physical report and do the system configuration
		 report = new ExtentReports();
		 report.attachReporter(htmlreport);
		 report.setSystemInfo("os", "Windows 10");
		 report.setSystemInfo("Environment", "Testing environment");
		 report.setSystemInfo("URL", "http://localhost:8888");
		 report.setSystemInfo("REPORTER Name", "Punit Ranjan");



	}

	public void onFinish(ITestContext context) {
	
		report.flush();
	}
	
		

	
		

}
