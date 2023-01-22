//package org.carnera.utils;
//
//import java.io.*;
//import java.util.Date;
//import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import static org.carnera.base.BaseTest.createFolder;
//
//
//public class LogUtil {
//
//    public static String fileName;
//    public static String Filepath;
//    public static Logger log;
//    static Date d;
//    String log4jConfigFile;
//    private int testStep;
//
//    /*
//     * Used for Logging
//     */
//    public static void logInfo(String message) {
//        log.info(message);
//
//    }
//
//    public static void logInfo(String message, boolean screenshot) {
//        log.info(message);
//
//    }
//
//    public static void logFailure(String message) {
//        log.log(Level.WARNING, message);
//
//    }
//
//    public static void logFailure(String message, boolean Screenshot) {
//        log.log(Level.WARNING, message);
//
//
//    }
//
//    public static void logExceptionMessage(Exception ex, String message) {
//        StringWriter errors = new StringWriter();
//        ex.printStackTrace(new PrintWriter(errors));
//        log.log(Level.WARNING, message, ex);
//    }
//
//    /*
//     * Configure Logging setting
//     */
//    public void configureLogging() {
//        try {
//            d = new Date();
//            fileName = "Log_" + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".log";
//            Filepath = createFolder.apply(System.getProperty("user.dir") + "/reports/Logs").toString();
//
//
//            File logFile = new File(Filepath + "/" + fileName);
//            FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile());
//
//            log4jConfigFile = System.getProperty("user.dir") + "/src/test/resources/logs/log4j.properties";
//            Properties props = new Properties();
//            InputStream configStream = new FileInputStream(log4jConfigFile);
//            props.load(configStream);
//
//
//            props.setProperty("log4jfilename", logFile.getPath());
//
//            log = Logger.getLogger("Carnera");
//            testStep = 1;
//        } catch (Exception e) {
//            System.out.println("Error While accessing Log file ");
//            e.printStackTrace();
//        }
//    }
//}