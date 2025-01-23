//package Utilities;
//
//import java.util.Date;
//import java.util.List;
//import org.testng.IReporter;
//import org.testng.ISuite;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.testng.xml.XmlSuite;
//
///*
//**==========~~~~~~~~~~==========~~~~~~~~~~==========~~~~~~~~~~==========
//*Author Name 		- DGovindhan
//*Created on  		- 25-Dec-2019
//*Description        - This implementation is for send email notification and future new implementation 
//*Other Information 	- 
//***==========~~~~~~~~~~==========~~~~~~~~~~==========~~~~~~~~~~==========
//*/
//public class MyTestListener implements ITestListener,IReporter {
//	static MyTestResults results = new MyTestResults();
//	// https://www.youtube.com/watch?v=TGBji64cVPE
//	// https://github.com/MisterVitoPro/tutorial/tree/master/src/main
//
//	@Override
//	public void onTestSuccess(ITestResult testResult) {
//		System.out.println(testResult.getName() + " was successful.");
//		//MyTestResults.getFeatureFileNameFromScenarioId();
//		// Write to Excel sheets
//		results.incrementPassed();
//		System.out.println("PASSED TESTS: " + results.getPassed());
//		System.out.println("TOTAL TESTS: " + results.getTotalTests());
//	}
//
//	@Override
//	public void onTestFailure(ITestResult testResult) {
//		System.out.println(
//				testResult.getName() + " was a failure.\n Throwable: " + testResult.getThrowable().getMessage());
//		System.out.println("New Test Started" + testResult.getName());
//		//MyTestResults.getFeatureFileNameFromScenarioId();
//		// Screenshots
//		// Write to Excel sheets
//		results.incrementFailed();
//		//results.incrementFeatureCount();
//		System.out.println("FAILED TESTS: " + results.getFailed());
//		System.out.println("TOTAL TESTS: " + results.getTotalTests());
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult testResult) {
//		System.out.println(testResult.getName() + " was skipped.");
//		//MyTestResults.getFeatureFileNameFromScenarioId();
//		results.incrementSkipped();
//		System.out.println("SKIPPED TESTS: " + results.getSkipped());
//		System.out.println("TOTAL TESTS: " + results.getTotalTests());
//	}
//
//	@Override
//	public void onFinish(ITestContext testContext) {
//		try {
//			results.writeToTxtFile();
//			results.writeToCSV();
//			System.out.println("End Date & Time of Execution - " + testContext.getEndDate());
//			MyTestResults.endDate = testContext.getEndDate();
//			results.getPercentageOfPassCount();
//			//consolidatedReport.mainTest();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	// Invoked each time before a test will be invoked.
//	@Override
//	public void onTestStart(ITestResult testResult) {
//
//		//System.out.println("New Test Started" + testResult.getName().toString());
//		
//	}
//	// Invoked after the test class is instantiated and before any configuration method is called.
//	@Override
//	public void onStart(ITestContext testContext) {
//		System.out.println("Start Date & Time of Execution - " + testContext.getStartDate());
//		MyTestResults.startDate = testContext.getStartDate();
//	}
//
//	public Date getStartDate() {
//		return MyTestResults.startDate;
//	}
//
//	public Date getEndDate() {
//		return MyTestResults.endDate;
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
//		// TODO Auto-generated method stub
//		
//	}
//}
///*
// ** ==========~~~~~~~~~~==========~~~~~~~~~~==========~~~~~~~~~~==========
// ** Copyright (C) 2008-2019 Schlumberger,- All Rights Reserved Unauthorized
// * copying of this file, via any medium is strictly prohibited Proprietary and
// * confidential
// ** ==========~~~~~~~~~~==========~~~~~~~~~~==========~~~~~~~~~~==========
// */



package com.incubyte.selenium.utility;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;


public class MyTestListener implements ITestListener,IReporter {
	static MyTestResults results = new MyTestResults();
	// https://www.youtube.com/watch?v=TGBji64cVPE
	// https://github.com/MisterVitoPro/tutorial/tree/master/src/main

	@Override
	public void onTestSuccess(ITestResult testResult) {
		System.out.println(testResult.getName() + " was successful.");
		//MyTestResults.getFeatureFileNameFromScenarioId();
		// Write to Excel sheets
		results.incrementPassed();
		System.out.println("PASSED TESTS: " + results.getPassed());
		System.out.println("TOTAL TESTS: " + results.getTotalTests());
	}

	@Override
	public void onTestFailure(ITestResult testResult) {
		System.out.println(
				testResult.getName() + " was a failure.\n Throwable: " + testResult.getThrowable().getMessage());
		System.out.println("New Test Started" + testResult.getName());
		//MyTestResults.getFeatureFileNameFromScenarioId();
		// Screenshots
		// Write to Excel sheets
		results.incrementFailed();
		//results.incrementFeatureCount();
		System.out.println("FAILED TESTS: " + results.getFailed());
		System.out.println("TOTAL TESTS: " + results.getTotalTests());
	}

	@Override
	public void onTestSkipped(ITestResult testResult) {
		System.out.println(testResult.getName() + " was skipped.");
		//MyTestResults.getFeatureFileNameFromScenarioId();
		results.incrementSkipped();
		System.out.println("SKIPPED TESTS: " + results.getSkipped());
		System.out.println("TOTAL TESTS: " + results.getTotalTests());
	}

	@Override
	public void onFinish(ITestContext testContext) {
		try {
			results.writeToTxtFile();
			results.writeToCSV();
			System.out.println("End Date & Time of Execution - " + testContext.getEndDate());
			MyTestResults.endDate = testContext.getEndDate();
			results.getPercentageOfPassCount();
			//consolidatedReport.mainTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Invoked each time before a test will be invoked.
	@Override
	public void onTestStart(ITestResult testResult) {

		//System.out.println("New Test Started" + testResult.getName().toString());
		
	}
	// Invoked after the test class is instantiated and before any configuration method is called.
	@Override
	public void onStart(ITestContext testContext) {
		System.out.println("Start Date & Time of Execution - " + testContext.getStartDate());
		MyTestResults.startDate = testContext.getStartDate();
	}

	public Date getStartDate() {
		return MyTestResults.startDate;
	}

	public Date getEndDate() {
		return MyTestResults.endDate;
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {
		// TODO Auto-generated method stub
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		
	}
}
/*
 ** ==========~~~~~~~~~~==========~~~~~~~~~~==========~~~~~~~~~~==========
 ** Copyright (C) 2008-2019 Schlumberger,- All Rights Reserved Unauthorized
 * copying of this file, via any medium is strictly prohibited Proprietary and
 * confidential
 ** ==========~~~~~~~~~~==========~~~~~~~~~~==========~~~~~~~~~~==========
 */