package genericUtilities;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TestNG
 * @author Keerthana S
 * abstraction and overriding example
 */

public class ListenersImplementation implements ITestListener  {

	
	//capture the current system date and time for screenshot name and report name
	
	Date d= new Date();//05-Nov-2024 19:15:25
	SimpleDateFormat f=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
	String date=f.format(d);
	
	//for extent reports
	
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		//capture the method name of @Test
		String methodName=result.getMethod().getMethodName();
	  
		/*@Test	 execution is started*/
		System.out.println(methodName+"Test script Execution Started");
	
		/* intimate extent reports for @Test execution*/
		test= report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		//capture the method name of @Test
		String methodName=result.getMethod().getMethodName();
		
		/*@Test	 execution is pass*/
		System.out.println(methodName+"Test script is pass");
		
		//LOG THE STATUS OF TEST AS PASS IN EXTENT REPORT
	    test.log(Status.PASS, methodName+"Test script is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//capture the method name of @Test
	    String methodName=result.getMethod().getMethodName();
	
	    /*@Test	 execution is fail*/
		System.out.println(methodName+"Test script is fail");
	 
		//capture the exception
		System.out.println(result.getThrowable());
	
		//LOG THE STATUS OF TEST AS fail IN EXTENT REPORT
	    test.log(Status.FAIL, methodName+"Test script is fail");
	  
	    /* log the exception in extent report*/
		test.log(Status.WARNING,result.getThrowable());
		
	    /*capture the screenshot*/
	    //from selenium utility
	    SeleniumUtility s= new SeleniumUtility();
	  
	    //Screenshot name configured
	    String screenshotName= methodName+date;
	    try {
			String path=s.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			/*attach the screenshot in extent report*/
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}		
	
	

	@Override
	public void onTestSkipped(ITestResult result) {
	
		//capture the method name of @Test
		String methodName=result.getMethod().getMethodName();
	
		/*@Test	 execution is skip*/
		System.out.println(methodName+"Test script is skip");	
	
		//capture the exception
		System.out.println(result.getThrowable());
	
		//LOG THE STATUS OF TEST AS PASS IN EXTENT REPORT
		test.log(Status.SKIP, methodName+"Test script is SKIP");
	
		/* log the exception in extent report*/
		test.log(Status.WARNING,result.getThrowable());
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		
		/*Suite level execution*/
		System.out.println("Suite Execution Started");
		
		/* Basic configuration of extent reports*/
		ExtentSparkReporter esr=new ExtentSparkReporter("/Users/jesus/Desktop/eclipse-workspace/AutomationFramework.QCO-SOEAJD-E12K/ExtentReports/Report -"+date+".html");
		esr.config().setDocumentTitle("SWAG LABS Execution Report ");
		esr.config().setReportName("Execution Build version 1.12");
		esr.config().setTheme(Theme.DARK);
	
		/* Feed the configuration to extent reports class*/
		report= new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Env","Test Env" );
		report.setSystemInfo("Base Browser","Chrome" );
		report.setSystemInfo("Base Plateform","Windows Family" );
		report.setSystemInfo("Base URL","TestEnv.com" );
		report.setSystemInfo("Reporter Name","Keerthana" );
	}

	@Override
	public void onFinish(ITestContext context) {
		
		/*Suite level execution*/
		System.out.println("Suite Execution finished");
		
		/*Generate the extent report*/
		report.flush();
	}

	
}
