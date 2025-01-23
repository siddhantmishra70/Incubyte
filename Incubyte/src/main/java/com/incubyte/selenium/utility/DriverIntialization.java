
package com.incubyte.selenium.utility;

import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.incubyte.selenium.constant.Constants;

import io.cucumber.java.Scenario;


public class DriverIntialization {
	public static WebDriver driver;
	public static Properties ppty;
	public static Logger logger;
	public static Scenario messageHandler;
	public static ThreadLocal<WebDriver> TLdriver = new ThreadLocal<WebDriver>();

	public static void intializeDriver(String drivernm) throws Exception {
		setWebDriver(driver, drivernm);
	}

	public static WebDriver setWebDriver(WebDriver driver, String drivernm) throws Exception {
		CommonFunctions.loadClassLoader();
		logger = LogManager.getLogger(DriverIntialization.class.getName());
		ppty = CommonFunctions.getObjDetails();
		drivernm = drivernm.toUpperCase();

		switch (drivernm) {

		case "CHROME":
			System.out.println("Selecting Chrome Browser for Execution");		
			ChromeOptions options=new ChromeOptions();

			options.addArguments("--no-sandbox");
	        options.addArguments("--disable-gpu");
//	        options.addArguments("--start-maximized");
	        options.addArguments("--disable-extensions");
	        options.addArguments("--disable-dev-shm-usage");
//	        options.addArguments("headless");
			TLdriver.set(new ChromeDriver(options)); 
			break;

		case "IE":
			TLdriver.set(new InternetExplorerDriver());
			break;

		case "FIREFOX":
			TLdriver.set(new FirefoxDriver());
			break;

		default:
			throw new Exception("Driver " + drivernm + " Not Defined");
		}
		maximiseWindow();
		setUpImplicitWait();
		return getDriver();
	}

	public static WebDriver getDriver() {
		return TLdriver.get();
	}

	public static void setUpImplicitWait() {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}

	public static void maximiseWindow() {
		getDriver().manage().window().maximize();
	}
}