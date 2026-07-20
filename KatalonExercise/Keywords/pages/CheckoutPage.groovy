package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import common.BasePage
import internal.GlobalVariable

public class CheckoutPage extends BasePage {
	private By addressDetailsTitle = By.xpath("//div/h2[contains(.,'Address Details')]") 
	private By reviewOrderTitle = By.xpath("//div/h2[contains(.,'Review Your Order')]")
	private By descriptionOrder = By.cssSelector("textarea[name='message']")
	private By placeOrderButton = By.cssSelector("a[href='/payment']")

	CheckoutPage verifyAddressDetailsTitleVisible() {
		verifyVisible(addressDetailsTitle)
		return this
	}

	CheckoutPage verifyReviewOrderTitle() {
		verifyVisible(reviewOrderTitle)
		return this
	}

	CheckoutPage setDescriptionOrder (String description) {
		setText(descriptionOrder, description)
		return this
	}

	PaymentPage clickOnPlaceOrder () {
		click(placeOrderButton)
		return new PaymentPage()
	}

}
