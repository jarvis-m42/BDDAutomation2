package org.carnera.utils;

import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.*;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.carnera.base.BaseTest.createFolder;


public class LogUtil {

	static Date d;
	public static String fileName;
	public static String Filepath;
	String log4jConfigFile;
	public static Logger log;
	private int testStep;

	/*
	 * Configure Logging setting
	 */
	public void configureLogging() {
		try {
			d = new Date();
			fileName = "Log_" + "_"+d.toString().replace(":", "_").replace(" ", "_") + ".log";
			Filepath = createFolder.apply(System.getProperty("user.dir") + "/reports/Logs").toString();


			File logFile = new File(Filepath + "/" + fileName);
			FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile());

			log4jConfigFile = System.getProperty("user.dir") + "/src/test/resources/logs/log4j.properties";
			Properties props = new Properties();
			InputStream configStream = new FileInputStream(log4jConfigFile);
			props.load(configStream);

			// configStream.close();
			props.setProperty("log4jfilename", logFile.getPath());
//			LogManager.resetConfiguration();
//			PropertyConfigurator.configure(props);
			log = Logger.getLogger("Carnera");
			testStep=1;
		} catch (Exception e) {
			System.out.println("Error While accessing Log file ");
			e.printStackTrace();
		}
	}

	/*
	 * Used for Logging
	 */
	public static void logInfo(String message) {
		log.info(message);
		ExtentListeners.testReport.get().info(message);
	}
	public static void logInfo(String message,boolean screenshot) {
		log.info(message);
		ExtentListeners.testReport.get().info(message);
		if(screenshot)
		{
			ExtentManager.captureScreenshot();
			ExtentListeners.testReport.get().info("<b>" + "<font color=" + "green>" + "Screenshot" + "</font>" + "</b>", MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
		}
	}
	public static void logFailure(String message) {
		log.log(Level.WARNING,message);
		ExtentListeners.testReport.get().fail(message);


	}
	public static void logFailure(String message,boolean Screenshot) {
		log.log(Level.WARNING,message);
		ExtentListeners.testReport.get().fail(message);
		if(Screenshot)	{
			ExtentManager.captureScreenshot();
			ExtentListeners.testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>", MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
		}

	}
	public static void logExceptionMessage(Exception ex,String message)
	{
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		log.log(Level.WARNING,message,ex);
		ExtentListeners.testReport.get().fail(message);

		log.log(Level.WARNING,errors.toString());
		ExtentListeners.testReport.get().fail(errors.toString());
		ExtentManager.captureScreenshot();
		ExtentListeners.testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>", MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
	}
}