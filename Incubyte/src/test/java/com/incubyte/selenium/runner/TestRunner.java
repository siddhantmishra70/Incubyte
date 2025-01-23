package com.incubyte.selenium.runner;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/main/resources/appFeatures"},
glue = {"com.incubyte.selenium.stepdefinition" }, tags="@Test", dryRun=false,
plugin = {"rerun:target/rerun.txt", "junit:target/Cucumberreports/Cucumber.xml", "pretty",
		"html:target/Cucumberreports/HtmlReport/HTMLreport.html", "json:target/Cucumberreports/Cucumber.json",
		"json:target/Cucumberreports/cucumber-report.json", "usage:target/Cucumberreports/cucumber-usage.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
	
public class TestRunner extends AbstractTestNGCucumberTests {
			
	
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("Execution is completed");
	}
}
/*
 ** Copyright (C) 2008-2019 Schlumberger,- All Rights Reserved Unauthorized
 * copying of this file, via any medium is strictly prohibited Proprietary and
 * confidential
 ** ==========~~~~~~~~~~==========~~~~~~~~~~==========~~~~~~~~~~==========
 */

