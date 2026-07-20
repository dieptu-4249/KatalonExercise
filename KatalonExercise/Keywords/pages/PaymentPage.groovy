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

public class PaymentPage extends BasePage {
	private By cardNameInput = By.cssSelector("input[data-qa='name-on-card']")
	private By cardNumberInput = By.cssSelector("input[data-qa='card-number']")
	private By cvcInput = By.cssSelector("input[data-qa='cvc']")
	private By expireMonthInput = By.cssSelector("input[data-qa='expiry-month']")
	private By expireYearInput = By.cssSelector("input[data-qa='expiry-year']")
	private By payAndConfirmButton = By.cssSelector("button#submit")
	private By alertSuccessMessage = By.cssSelector("form div.alert-success")

	PaymentPage setCardNameInput (String cardName) {
		setText(cardNameInput, cardName)
		return this
	}

	PaymentPage setCardNumberInput (String cardNumber) {
		setText(cardNumberInput, cardNumber)
		return this
	}

	PaymentPage setCvcInput (String cvc) {
		setText(cvcInput, cvc)
		return this
	}

	PaymentPage setExpireMonthInput (String month) {
		setText(expireMonthInput, month)
		return this
	}

	PaymentPage setExpireYearInput (String year) {
		setText(expireYearInput, year)
		return this
	}

	PaymentPage clickOnPayAndConfirmButton() {
		click(payAndConfirmButton)
		return this
	}

	PaymentPage verifyOrderPlacedSuccessfully() {
		verifyVisible(alertSuccessMessage)
		return this
	}

	OrderPlacedPage waitForRedirectToOrderPlacedPage() {
		waitForUrlContains("/payment_done")
		return new OrderPlacedPage()
	}

}
