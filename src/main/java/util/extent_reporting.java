package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extent_reporting extends WebBrowser
{
	public static ExtentReports exReport;
	public static ExtentTest exTest;
	
	 public static void initializeReport()
	 {	 
		
		String mytimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());		
		//report = new ExtentReports("C:\\Users\\ksiddiqu\\OneDrive - Capgemini\\Documents\\New folder\\mvn-proj\\test-output\\ExtentReportResults.html");
		//test = report.startTest("ChapterOneTest_withExtentReport");
		String extrprtpath = "C:\\Users\\ksiddiqu\\OneDrive - Capgemini\\Documents\\New folder\\ddt-proj" + 
		"\\test-output\\TestExecutionReports\\" + "TestExecutionReport" +"_" + mytimeStamp +".html" ;
	 	// instead of user dire added path
		exReport = new ExtentReports(extrprtpath, true);		
		/*exReport = new ExtentReports(extrprtpath);
		exReport.*/
	 }
	 
	 public static void initializeTestcase(String TCid)
	 {
		 exTest = exReport.startTest(TCid);
	 }
	 
	 public static void executeReport(String stepdescription , String Stepstatus) throws IOException
	 {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		TakesScreenshot takescrn= (TakesScreenshot) driver;

		File SrcFile=takescrn.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(System.getProperty("user.dir") + "\\test-output\\TestExecutionReports\\screenshots\\"+ timeStamp +".jpg");
		Files.copy(SrcFile, DestFile);
		
		
		
		 if(Stepstatus.contains("PASS"))
		 {
			 exTest.log(LogStatus.PASS,stepdescription + exTest.addScreenCapture(System.getProperty("user.dir") +
					 "\\test-output\\TestExecutionReports\\screenshots\\" + timeStamp + ".jpg")  );
			 
		 }		 
		 if(Stepstatus.contains("FAIL"))
		 {
			 exTest.log(LogStatus.FAIL,stepdescription + exTest.addScreenCapture(System.getProperty("user.dir") + 
					 "\\test-output\\TestExecutionReports\\screenshots\\" +timeStamp + ".jpg"));
		 }
		 
		 
	 }
	 
	 public static void endReport()
	 {
		try {
			 exReport.endTest(exTest);
			 exReport.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 
	 
	 
}
