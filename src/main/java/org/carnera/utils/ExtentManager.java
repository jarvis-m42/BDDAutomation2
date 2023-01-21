package org.carnera.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.Date;

import static org.carnera.base.BaseTest.driver;

/*
 * Extent Manager is used for reporting management
 */
public class ExtentManager {

	private static ExtentReports extent;
	public static String screenshotName;
	
	public synchronized static ExtentReports createInstance(String fileName) {
		try {	
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle(fileName);
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setReportName(fileName);

			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Automation Tester", System.getProperty("user.name"));
			extent.setSystemInfo("Organization", "Carnera");
			extent.setSystemInfo("Application", "Carnera Dashboard");
			//extent.setSystemInfo("App Environment",ConfigReader.env);
			return extent;
		} catch (Exception e) {
			System.out.println("Exception occurred while creating instance of Extent Report");
			e.printStackTrace();
			return extent;
		}
	}

	/*
	 * To capture screenshot

	 */
	public static void captureScreenshot() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/reports/" + screenshotName));
		} catch (Exception e) {
			System.out.println("Exception Occurred while capturing screenshot");
			e.printStackTrace();
		}

	}




}
