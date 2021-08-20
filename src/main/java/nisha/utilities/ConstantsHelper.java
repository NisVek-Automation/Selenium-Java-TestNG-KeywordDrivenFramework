package nisha.utilities;

import java.io.File;
import java.time.Duration;

/** 
 * Represents Project specific constant values.
 * @author Nisha Vekariya
 * @author https://github.com/NisVek-Automation
 * @version 1.0
*/
public class ConstantsHelper {

	//File paths
	public static final String projectPath = System.getProperty("user.dir");
	public static final String log4jPropertyFilePath = projectPath + "/src/main/java/nisha/resources/log4j.properties";
	public static final String reportFilePath = projectPath + "/reports/";
	public static final String pageObjectPropertyPath = projectPath + "/src/test/java/nisha/pageObjectProperties/";
	public static final String testSuiteExcelSheetPath = projectPath + "/src/main/java/nisha/resources/TestSuite.xlsx";
	public static final String TestStepDataExcelSheetData = projectPath + "/src/main/java/nisha/resources/TestCasesData.xlsx";
	public static final String screenshotsPath = projectPath + "/screenShots/";
	public static final String reportIndexFileName="index";
	
	//PageObject Property File Name
	public static final String homePagePropetryPath = pageObjectPropertyPath + "homePage.Properties";
	public static final String loginPagePropetryPath = pageObjectPropertyPath + "login.Properties";
	public static final String registrationaPagePropetryPath = pageObjectPropertyPath + "registrationaPage.Properties";
	
	public static final String pass = "Pass";
	public static final String fail = "Fail";
	
	//Wait timing
	public static final Duration explicitWait = Duration.ofMillis(10000);
	public static final long implicitWait = 10;
	public static final Duration pageloadTime = Duration.ofMillis(130000);
	
	//Suite
	public static final String suiteNameLabel="Test Suite";
	public static final String suiteName="TestCasesSuite";
	
	
	//Report variables
	public static final String environment = "QA";
	public static final String release = "123";
	
}
