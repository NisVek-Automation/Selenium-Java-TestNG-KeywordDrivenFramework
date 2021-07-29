package nisha.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import nisha.config.Keywords;
import nisha.enums.Browsers;
import nisha.utilities.ConstantsHelper;
import nisha.utilities.ReportHelper;

public class TestController extends TestBase {

	@BeforeClass
	public void initBrowser() throws IOException {
		Initialize();
	}

	@Test
	public void TestCaseController() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException {

		String startTime = TestBase.now("dd.MMMM.yyyy hh.mm.ss aaa");

		ReportHelper.startTesting(ConstantsHelper.reportIndexFileName, startTime);// ,
																					// "QA",
																					// "1706.5");

		ReportHelper.startSuite(ConstantsHelper.suiteNameLabel);
		String TCStatus = ConstantsHelper.pass;

		// loop through the test cases
		for (int TC = 2; TC <= SuiteData.getRowCount(ConstantsHelper.suiteName); TC++) {

			// This will Read testCase ID from TestSuite e.g (TC01,TC02)
			String TestCaseID = SuiteData.getCellData(ConstantsHelper.suiteName, "TCID", TC);
			// This will Read RunMode from TestSuite for testID
			String RunMode = SuiteData.getCellData(ConstantsHelper.suiteName, "RunMode", TC);

			if (!RunMode.equals("Y")) {
				// skip the test case
				ReportHelper.addTestCase(TestCaseID, startTime, TestBase.now("dd.MMMM.yyyy hh.mm.ss aaa"), "Skipped");
				if (driver != null) {
					driver.quit();
				}

			}else{
				String TSStatus = ConstantsHelper.pass;
				driver = TestBase.selectBrowser(Browsers.CHROME.name());

				// For testCase Id get the numbers of Test data rows from
				// TestSuite1Data.xlsx
				int rows = TestStepData.getRowCount(TestCaseID);

				// This is required to handle the scenarios where there is no
				// test data.
				// in that case we need to run the test case once
				if (rows < 2) {
					rows = 2;
				}

				// loop through test data from TestCaseData.xls
				for (int TD = 2; TD <= rows; TD++) {
					if (driver == null) {
						driver = TestBase.selectBrowser(Browsers.CHROME.name());
					}
					// loop through the test steps Form TestSuite.xlsx for each
					for (int TS = 2; TS <= SuiteData.getRowCount(TestCaseID); TS++) {
						keyword = SuiteData.getCellData(TestCaseID, "Keyword", TS);
						webElement = SuiteData.getCellData(TestCaseID, "WebElement", TS);
						ProceedOnFail = SuiteData.getCellData(TestCaseID, "ProceedOnFail", TS);
						TSID = SuiteData.getCellData(TestCaseID, "TSID", TS);
						Description = SuiteData.getCellData(TestCaseID, "Description", TS);

						TestDataField = SuiteData.getCellData(TestCaseID, "TestDataField", TS);

						if (TestDataField != null && TestDataField != "") {
							TestData = TestStepData.getCellData(TestCaseID, TestDataField, TD);
						}

						if (TestDataField.equals("email")) {
							TestData = "test" + System.currentTimeMillis() + "@gmail.com";
						}

						Method method = Keywords.class.getMethod(keyword);
						TSStatus = (String) method.invoke(method);

						if (TSStatus.contains("Failed")) {
							// take the screenshot
							String filename = TestCaseID + "[" + (TD - 1) + "]" + keyword;
							String screenShot = TestBase.getScreenShot(filename);

							TCStatus = TSStatus;
							// report error
							ReportHelper.addKeyword(Description, keyword, TSStatus, screenShot);

							if (ProceedOnFail.equals("N")) {
								break;
							}
						} else {
							ReportHelper.addKeyword(Description, keyword, TSStatus, null);
						}
					}
					ReportHelper.addTestCase(TestCaseID, startTime, TestBase.now("dd.MMMM.yyyy hh.mm.ss aaa"),TCStatus);
					driver.quit();
				}
			}// Closed the If condition
		}//first for loop
		ReportHelper.endSuite();
		ReportHelper.updateEndTime(TestBase.now("dd.MMMM.yyyy hh.mm.ss aaa"));
	}

	@AfterClass
	public void quitBrowser() {
		System.out.println("In quitBrowser---------------------------");
		if (driver != null) {
			driver.quit();
		}
	}
}
