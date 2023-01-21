package org.carnera.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.carnera.base.BaseTest.createFolder;


public class ExtentListeners implements ITestListener {

	private static ExtentTest extentTest;
	private static Map extentFeatureMap ;
	private static Map extentScenarioMap ;
	private static Map screenShotPathMap ;
	private static Map gherkinNodeMap ;
	private static ITestResult result;
	static Date d ;
	static String fileName ;
	static String Filepath ;
	private static ExtentReports extent ;
	public static ThreadLocal<ExtentTest> testReport ;
	
	public static String FileName;
	
	public void ConfigureExtentReport()
	{
		extentFeatureMap = new HashMap();
		extentScenarioMap = new HashMap();
		screenShotPathMap = new HashMap();
		gherkinNodeMap = new HashMap();
		d = new Date();
		fileName = "AutomationReport" +"_"+ d.toString().replace(":", "_").replace(" ", "_") + ".html";
		Filepath = createFolder.apply(System.getProperty("user.dir") + "/reports").toString();
		extent = ExtentManager.createInstance(Filepath + "/" + fileName);
		testReport = new ThreadLocal<ExtentTest>();
		FileName=Filepath + "/" + fileName;
	}
	@Override
	public synchronized void onTestStart(ITestResult result) {
		this.result=result;
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		this.result=result;
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		this.result=result;
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		this.result=result;
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(" Test Percentage");
	}

	@Override
	public synchronized void onStart(ITestContext result) {
		System.out.println("On Test Start");
	}

	@Override
	public synchronized void onFinish(ITestContext result) {
		System.out.println("On Test Finish");
	}

	public static synchronized String getScreenshotPath() {
		return (String) screenShotPathMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void putScreenshotPath(String path) {
		screenShotPathMap.put((int) (long) (Thread.currentThread().getId()), path);
	}

	public static synchronized ExtentTest getFeature() {
		return (ExtentTest) extentFeatureMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized ExtentTest getScenario() {
		return (ExtentTest) extentScenarioMap.get((int) (long) (Thread.currentThread().getId()));
	}
	public static synchronized ExtentTest startFeature(String featureName) throws ClassNotFoundException {
		try {
			extentTest = extentTest.createNode(new GherkinKeyword("Feature"), featureName);
			extentFeatureMap.put((int) (long) (Thread.currentThread().getId()), extentTest);
		} catch (Exception e) {
			System.out.println("Exception while starting feature");
			e.printStackTrace();
		}
		return extentTest;
	}

	public static synchronized ExtentTest startScenario(String scenarioName) {
		try {
			extentTest = extentTest.createNode(Scenario.class, scenarioName);
			extentScenarioMap.put((int) (long) (Thread.currentThread().getId()), extentTest);
		} catch (Exception e) {
			System.out.println("Exception Whole starting scenario");
			e.printStackTrace();
		}
		return extentTest;
	}
	/*
	 * Creating node of gherkin keyword with description
	 */
	public static synchronized ExtentTest CreateGherkinNode(String GherkinKeyword, String name) {
		try {
			extentTest = getScenario();
			extentTest = extentTest.createNode(new GherkinKeyword(GherkinKeyword), name);
			gherkinNodeMap.put((int) (long) (Thread.currentThread().getId()), extentTest);
			testReport.set(extentTest);
		} catch (Exception e) {
			System.out.println("Exception while creating gherking Node");
			e.printStackTrace();
		}
		return extentTest;
	}
	/*
	 * When test is created 
	 */
	public static synchronized ExtentTest CreateTest(String testCaseID,String TestDataIterationID,String TestCaseName)
	{
		try {
			System.out.println(testCaseID+"-"+TestDataIterationID+" testcase started");
					extentTest = extent
					.createTest(testCaseID+"-"+TestDataIterationID+"_"+TestCaseName);
					testReport.set(extentTest);
		} catch (Exception e) {
			System.out.println("Exception while creating test");
			e.printStackTrace();
		}
		return extentTest;
	}
	/*
	 * When test Succeed
	 */
	public static synchronized ExtentTest TestSuccess(String testCaseID)
	{
		try {
			String logText = "<b>" + "TEST CASE:- " + testCaseID.toUpperCase() + " PASSED" + "</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			testReport.get().pass(m);
		} catch (Exception e) {
			System.out.println("Exception in Extent Test Test success ");
			e.printStackTrace();
		}
		return extentTest;
	}
	/*
	 * When test get Failed
	 */
	public static synchronized ExtentTest TestFailure(String testCaseID)
	{
	try {
			ExtentManager.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>", MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
			String logText = "<b>" + "Test Case:- " + testCaseID + " Failed" + "</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			testReport.get().log(Status.FAIL, m);
	} catch (Exception e) {
		System.out.println("Exception in Extent Test Test Failure");
		e.printStackTrace();
	}
	return extentTest;
	}
	

	/*
	 * When test get skipped
	 */
	public static synchronized ExtentTest TestSkip(String testCaseID)
	{
		try {
			String logText = "<b>" + "Test Case:- " + testCaseID + " Skipped" + "</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			testReport.get().skip(m);
		} catch (Exception e) {
			System.out.println("Exception in Extent TestSkip");
			e.printStackTrace();
		}
		return extentTest;
	}
	
	public static void FlushReport()
	{
		extent.flush();
		System.out.println("flushing Report");
	}
}
