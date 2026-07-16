package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.time.Duration

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

public class BasePage {
	protected int DEFAULT_TIMEOUT = 10;
	protected WebDriver driver = DriverFactory.getWebDriver()

	void goToUrl(String url) {
		driver.get(url)
	}

	WebElement find(By locator) {
		return driver.findElement(locator)
	}
	List<WebElement> finds (By locator){
		return driver.findElements(locator)
	}

	void waitVisible (By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
				.until(ExpectedConditions.visibilityOfElementLocated(locator))
	}

	void waitClickable (By locator) {
		new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
				.until(ExpectedConditions.elementToBeClickable(locator))
	}

	void click(By locator) {
		waitClickable(locator)
		find(locator).click()
	}

	boolean isDisplayed(By locator) {
		try {
			waitVisible(locator)
			return find(locator).isDisplayed()
		} catch (Exception e) {
			return false
		}
	}

	void setText(By locator, String text) {

		waitVisible(locator)

		WebElement element = find(locator)

		element.clear()
		element.sendKeys(text)
	}

	String getText(By locator) {

		waitVisible(locator)

		return find(locator).getText()
	}


	void verifyVisible(By locator) {
		assert isDisplayed(locator)
	}

	void verifyTitle (String expectedTitle) {
		assert driver.getTitle().equals(expectedTitle)
	}
	void scrollToElement(By locator) {

		WebUI.executeJavaScript(
				"arguments[0].scrollIntoView({block:'center'});",
				[find(locator)]
				)
	}
	void waitForUrlContains(String value) {

		WebDriverWait wait = new WebDriverWait(
				driver,
				Duration.ofSeconds(DEFAULT_TIMEOUT)
				)

		wait.until(
				ExpectedConditions.urlContains(value)
				)
	}
}
