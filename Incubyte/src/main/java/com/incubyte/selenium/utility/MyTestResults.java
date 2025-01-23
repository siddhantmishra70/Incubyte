package com.incubyte.selenium.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.incubyte.selenium.constant.Constants;

public class MyTestResults extends DriverIntialization{
	static int passed;
	static int failed;
	static int skipped;
	static int TotalTests;
	static Date startDate;
	static Date endDate;
	static String strPercentage;
	static int FeatureCount;

	public int getPassed() {
		return MyTestResults.passed;
	}

	public int getFailed() {
		return MyTestResults.failed;
	}

	public int getSkipped() {
		return MyTestResults.skipped;
	}

	public int getTotalTests() {
		TotalTests = MyTestResults.passed + MyTestResults.failed + MyTestResults.skipped;
		return (MyTestResults.passed + MyTestResults.failed + MyTestResults.skipped);
	}

	public void incrementPassed() {
		MyTestResults.passed++;
	}

	public void incrementFailed() {
		MyTestResults.failed++;
	}

	public void incrementSkipped() {
		MyTestResults.skipped++;
	}

	public void writeToTxtFile() throws IOException {
		File file = new File("target\\TestResult.txt");

		try (FileWriter fw = new FileWriter(file); BufferedWriter bWriter = new BufferedWriter(fw)) {
			bWriter.write("PASSED=" + MyTestResults.passed + "\n");
			bWriter.write("FAILED=" + MyTestResults.failed + "\n");
			bWriter.write("SKIPPED=" + MyTestResults.skipped + "\n");
			bWriter.write("TOTAL=" + this.getTotalTests() + "\n");
		}
	}

	public void writeToCSV() throws IOException {
		File file = new File("target\\TestResults.csv");
		try (FileWriter fw = new FileWriter(file); BufferedWriter bWriter = new BufferedWriter(fw)) {
			bWriter.write("PASSED," + MyTestResults.passed + "\n");
			bWriter.write("FAILED," + MyTestResults.failed + "\n");
			bWriter.write("SKIPPED," + MyTestResults.skipped + "\n");
			bWriter.write("TOTAL," + this.getTotalTests() + "\n");
		}
	}
	public void getPercentageOfPassCount() {
		strPercentage = new DecimalFormat("##.##").format(((float)MyTestResults.passed/(float)this.getTotalTests()*100));
		System.out.println("Total no of Test case passed Percentage - " + strPercentage);
	}
	
	public static void takescreenshot() {
		//System.out.println("screenshot method started");
		File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String fileWithPath;

		String pattern = "MM/dd/yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime();
		String todayAsString = df.format(today);
		String strDate = todayAsString.replaceAll("\\s","");
		strDate = strDate.replaceAll("/","");
		strDate = strDate.replaceAll(":","");
		fileWithPath = "target/Screenshots/"+strDate+" "+Constants.SCENARIO_NAME+".jpg";
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		try {
		FileUtils.copyFile(scrFile, DestFile);
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	/*public static String getFeatureFileNameFromScenarioId() {
	    String featureName = "Feature ";
	    Scenario txt = DriverIntialization.messageHandler;
	    String rawFeatureName2 = DriverIntialization.messageHandler.getId();
	    String rawFeatureName = DriverIntialization.messageHandler.getId().split("/")[3].replace("-"," ");
	    featureName = rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);

	    return featureName;
	}
	public void incrementFeatureCount() {
		MyTestResults.FeatureCount++;
	}*/

	
}