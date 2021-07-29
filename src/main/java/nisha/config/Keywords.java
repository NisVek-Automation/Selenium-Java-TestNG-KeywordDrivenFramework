package nisha.config;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import nisha.controller.TestBase;
import nisha.utilities.ConstantsHelper;
import nisha.utilities.LoggerHelper;

/**
 * This class contains all the keywords which required for testing.
 * @author Nisha Vekariya
 * @version 1.0
 */
public class Keywords extends TestBase {
	private final static Logger logger = LoggerHelper.getLogger(Keywords.class);

	/**
	 * This method navigate.
	 * @author Nisha
	 * @param driver
	 *            -> Locator as string
	 * @return WebElement
	 */
	private static WebElement getWebElement(String locator) throws Exception {
		String keywordValue = Repository.getProperty(locator);
		return getLocator(keywordValue);
	}

	/**
	 * This method navigate.
	 * @author Nisha
	 * @param driver
	 *            -> Locator as string
	 * @return List of WebElements
	 */
	private static List<WebElement> getWebElements(String locator) throws Exception {
		return getLocators(Repository.getProperty(locator));
	}

	/**
	 * This method navigate.
	 * @author Nisha Vekariya
	 * @return String as pass/fail
	 */
	public static String navigate() {
		driver.get(webElement);
		logger.info("Navigate is called");
		return ConstantsHelper.pass;
	}

	/**
	 * This method allws to enter the data in element.
	 * @author Nisha Vekariya
	 * @return String as pass/fail
	 */
	public static String inputText() {
		logger.info("InputText is called");
		try {
			expliciteWait();
			getWebElement(webElement).sendKeys(TestData);
		} catch (Throwable t) {
			return "Failed - Element not found " + webElement;
		}
		return ConstantsHelper.pass;
	}

	/**
	 * This method Click on link or button.
	 * @author Nisha Vekariya
	 * @return String as pass/fail
	 */
	public static String click() {
		logger.info("ClickOnLink is called");
		try {
			expliciteWait();
			getWebElement(webElement).click();
		} catch (Throwable t) {
			t.printStackTrace();
			return "Failed - Element not found " + webElement;
		}
		return ConstantsHelper.pass;
	}

	/**
	 * This method verify the text.
	 * @author Nisha Vekariya
	 * @return String as pass/fail
	 */
	public static String verifyText() {
		logger.info("VerifyText is called");
		try {
			expliciteWait();
			String ActualText = getWebElement(webElement).getText();
			logger.info(ActualText);
			if (!ActualText.equals(TestData)) {
				return "Failed - Actual text " + ActualText + " is not equal to to expected text " + TestData;
			}
		} catch (Throwable t) {
			return "Failed - Element not found " + webElement;
		}
		return ConstantsHelper.pass;
	}

	/**
	 * This method verify the text of element.
	 * @author Nisha Vekariya
	 * @return String as pass/fail
	 */
	public static String verifyAppText() {
		logger.info("VerifyText is called");
		try {
			expliciteWait();
			String ActualText = getWebElement(webElement).getText();
			if (!ActualText.equals(AppText.getProperty(webElement))) {
				return "Failed - Actual text " + ActualText + " is not equal to to expected text "
						+ AppText.getProperty(webElement);
			}
		} catch (Throwable t) {
			return "Failed - Element not found " + webElement;
		}
		return ConstantsHelper.pass;
	}

	/**
	 * This method mouse over on the element.
	 * @author Nisha Vekariya
	 * @return String as pass/fail
	 */
	public static String mouseOver() {
		try {
			expliciteWait();
			WebElement element = getWebElement(webElement);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			Thread.sleep(1000);
		} catch (Exception e) {
			return "Failed - Element not found " + webElement;
		}
		return ConstantsHelper.pass;
	}

	/**
	 * This method select value from dropdown.
	 * @author Nisha Vekariya
	 * @return String as pass/fail
	 */
	public static String selectByValue() {
		try {
			expliciteWait();
			WebElement element = getWebElement(webElement);
			Select select = new Select(element);
			select.selectByValue(TestData);
		} catch (Exception e) {
			return "Failed - Element not found " + webElement;
		}
		return ConstantsHelper.pass;
	}

	/**
	 * This method select value from dropdown using visibletext
	 * @author Nisha Vekariya
	 * @return String as pass/fail
	 */
	public static String selectByVisibleText() {
		try {
			expliciteWait();
			WebElement element = getWebElement(webElement);
			Select select = new Select(element);
			select.selectByVisibleText(TestData);
		} catch (Exception e) {
			return "Failed - Element not found " + webElement;
		}
		return ConstantsHelper.pass;
	}

	/**
	 * This method select value from dropdown using index
	 * @author Nisha Vekariya
	 * @return String as pass/fail
	 */
	public static String selectByIndex() {
		try {
			WebElement element = getWebElement(webElement);
			Select select = new Select(element);
			select.selectByIndex(Integer.parseInt(TestData));
		} catch (Exception e) {
			return "Failed - Element not found " + webElement;
		}
		return ConstantsHelper.pass;
	}

	/**
	 * This Method will return web element.
	 * 
	 * @author Nisha
	 * @param locator
	 *            locator as String
	 * @return WebElement object
	 * @throws Exception
	 */
	private static WebElement getLocator(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];
		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.tagName(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	/**
	 * This Method will return web element.
	 * 
	 * @author Nisha
	 * @param locator
	 *            locator as String
	 * @return WebElement objects
	 * @throws Exception
	 */
	private static List<WebElement> getLocators(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElements(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return driver.findElements(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return driver.findElements(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElements(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	/**
	 * This Method will return web element.
	 * 
	 * @author Nisha
	 * @param locator
	 *            locator as String
	 * @return WebElement objects
	 * @throws Exception
	 */
	private static void expliciteWait() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, ConstantsHelper.explicitWait);
			wait.until(ExpectedConditions.visibilityOf(getWebElement(webElement)));
			logger.info("Element found..." + webElement.toString());
		} catch (Throwable e) {
			throw new TimeoutException(webElement, e);
		}

	}

	/**
	 * This method Click on radio button.
	 * 
	 * @author Nisha Vekariya
	 * @return String as pass/fail
	 */
	public static String clickRadioButton() {
		try {
			expliciteWait();
			getWebElement(webElement).click();
		} catch (Throwable t) {
			return "Failed - Element not found " + webElement;
		}
		return ConstantsHelper.pass;
	}

	public static String waitFor() throws InterruptedException {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			return "Failed - unable to load the page";
		}
		return "Pass";
	}
	
	/**
	 * This method close the browser
	 * 
	 * @author Nisha
	 * @return It does not return anything
	 */
	public static void closeBrowser() {
		driver.quit();
	}

}
