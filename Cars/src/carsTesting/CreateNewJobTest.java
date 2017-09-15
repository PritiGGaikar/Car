package carsTesting;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import common_Function.WebDriverPass;

public class CreateNewJobTest extends WebDriverPass {
	ExtentReports report;
	ExtentTest test;
	CreateNewJob w = new CreateNewJob();

	@Test(priority = 1)
	public void CreateNewJob() throws Exception {
		try {
			test = report.startTest("CreateNewJobs");
			w.CreateNewJobs(driver);
			Assert.assertTrue(true);

		} catch (Exception e) {
			String exception=e.getMessage();
			System.out.println("Fail :" + exception);
			Assert.assertTrue(false);
			
		}

		test.log(LogStatus.PASS, "Technical-->Worklist Index--> JobStatus");
	
}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test failed " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
		} else {
			test.log(LogStatus.PASS, "Test passed");
		}
		report.endTest(test);
		report.flush();
	}

	@BeforeSuite
	public void beforeSu() {
		report = CreateNewJob.getReporter(path.concat("Report.html"));
	}

	@AfterSuite
	public void afterSu() {
		report.close();
	}


}
