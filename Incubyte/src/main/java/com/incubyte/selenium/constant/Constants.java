package com.incubyte.selenium.constant;

public class Constants {
    public static final String EXTENT_REPORT_PATH;
    public static final String JSON_PATH;
    public static final Integer IMPLICIT_WAIT = 8;
    public static final Integer EXPLICIT_WAIT = 30;
    public static final String SCREENSHOT_PATH;
    public static final String TEST_DATA_PATH;
    public static final String EXTENT_CONFIG_FILE_PATH;
    public static final String DOWNLOAD_FILE_PATH;
    public static final String CONFIG_FILE_PATH;
    public static String SCENARIO_NAME = "";

    static {
        String userDir = System.getProperty("user.dir");
        EXTENT_REPORT_PATH = userDir + "\\ExtentReports\\index.html";
        JSON_PATH = userDir + "\\src\\test\\resources\\config.json";
        SCREENSHOT_PATH = userDir + "\\Screenshots";
        TEST_DATA_PATH = userDir + "\\src\\test\\resources\\testdata.xlsx";
        EXTENT_CONFIG_FILE_PATH = userDir + "\\src\\test\\resources\\extentreport.xml";
        DOWNLOAD_FILE_PATH = userDir + "\\target\\Cucumberreports";
        CONFIG_FILE_PATH = userDir + "\\src\\main\\resources\\config.properties";
    }

    private Constants() {
        // Prevent instantiation
    }
}
