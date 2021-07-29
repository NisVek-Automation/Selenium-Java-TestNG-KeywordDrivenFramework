package nisha.controller;

import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.OS;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import nisha.enums.Browsers;
import nisha.enums.OperatingSystems;
import nisha.utilities.ConstantsHelper;
import nisha.utilities.ExcelsheetHelper;

public class TestBase {

	public static WebDriver driver;
	public static Properties Repository = new Properties();
	//public static Properties Config = new Properties();
	public static Properties AppText = new Properties();
	public static ExcelsheetHelper SuiteData;
	public static ExcelsheetHelper TestStepData;

	public static String keyword;
	public static String webElement;
	public static String TestDataField;
	public static String TestData;
	public static String ProceedOnFail;
	public static String TSID;
	public static String Description;
	public static File f;
	public static FileInputStream FI;

	public static void Initialize() throws IOException {

		SuiteData = new ExcelsheetHelper(ConstantsHelper.testSuiteExcelSheetPath);
		TestStepData = new ExcelsheetHelper(ConstantsHelper.TestStepDataExcelSheetData);
		f = new File(ConstantsHelper.loginPagePropetryPath);
		FI = new FileInputStream(f);
		Repository.load(FI);

		f = new File(ConstantsHelper.homePagePropetryPath);
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(ConstantsHelper.registrationaPagePropetryPath);
		FI = new FileInputStream(f);
		Repository.load(FI);

	}

	public static String now(String format) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat fm = new SimpleDateFormat();
		return fm.format(cal.getTime());
	}

	public static WebDriver selectBrowser(String browser) {
		if (System.getProperty("os.name").toLowerCase().contains(OperatingSystems.WINDOW.name().toLowerCase())) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		} else if (System.getProperty("os.name").toLowerCase().contains(OperatingSystems.MAC.name().toLowerCase())) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ConstantsHelper.implicitWait, TimeUnit.SECONDS);
		return driver;
	}

	public static String getScreenShot(String fileName) {
		if (driver == null) {
			return null;
		}
		if (fileName == "") {
			fileName = "blank";
		}
		Reporter.log("captureScreen method called");
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File screFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			destFile = new File(ConstantsHelper.screenshotsPath + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(screFile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
					+ "'height='100' width='100'/></a>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}

}
