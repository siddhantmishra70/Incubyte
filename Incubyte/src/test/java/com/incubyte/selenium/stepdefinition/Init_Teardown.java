package com.incubyte.selenium.stepdefinition;
import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.TreeMap;



import org.testng.annotations.AfterSuite;

import com.incubyte.selenium.utility.CommonFunctions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Init_Teardown extends CommonFunctions {
	static TreeMap<String, String> map = null;
	static Entry<String, String> lastfile;
	public static Properties ppty;

	@Before(order = 0)
	public static void SetUp(Scenario s) {
		messageHandler = s;
		CommonFunctions.WriteLog(" Test Case name  - " + s.getName());
		System.out.println(" Test Case name  - " + s.getName());
	}
	
	@Before(order = 1)
	public static void initDriver() throws Exception {
		ppty = CommonFunctions.getObjDetails();
		String driverName = ppty.getProperty("browser");
		intializeDriver(driverName);		
	}

	@Before(order = 2)
	public void loginInit() throws Exception {
		actionInit();
		webDriverWaitInit();
		javascriptInit();
		loadBaseURL();
	}
	
	@After
    public void afterScenario(Scenario scenario) throws InterruptedException, IOException {
        try {
            if (getDriver() != null) {
                if (scenario.isFailed()) {
                	String TestCaseName = scenario.getName();
    				scenario.log("Current Page URL is " + getDriver().getCurrentUrl());
    				messageHandler.log(TestCaseName + "is failed =  " + scenario.isFailed());
    				scenario.attach(embedScreenshot(), "image/png",TestCaseName);//added attach and new string Testcasename
    				File currentDir = new File(System.getProperty("user.dir") + "/target/Cucumberreports/Screenshots/");
    				map = new TreeMap<String, String>();
                }
                logger.info("Test Case Completed");
            }
        } catch (Exception e) {
            logger.info("Exception during afterScenario: " + e.getMessage());
        } finally {
            if (getDriver() != null) {
            	getDriver().quit();
//            	killChromeDriver();
            }
        }
    }
	
	public static void killChromeDriver() {
		try {
			ProcessBuilder builder = new ProcessBuilder("TASKKILL", "/F", "/IM", "chrome.exe");
            Process process = builder.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Chromedriver processes terminated successfully.");
            } else {
                System.out.println("Failed to terminate chromedriver processes.");
            }
		} catch (Exception e) {
		}
	}

	@AfterSuite
	public void quitDriver() {
		
//		getDriver().quit();
	}
	
	@AfterStep    
	public void takeScreensot(Scenario ss) {
		com.incubyte.selenium.constant.Constants.SCENARIO_NAME = ss.getName();
	}
}
/*
 ** ==========~~~~~~~~~~==========~~~~~~~~~~==========~~~~~~~~~~==========
 ** Copyright (C) 2008-2019 Schlumberger,- All Rights Reserved Unauthorized
 * copying of this file, via any medium is strictly prohibited Proprietary and
 * confidential
 ** ==========~~~~~~~~~~==========~~~~~~~~~~==========~~~~~~~~~~==========
 */