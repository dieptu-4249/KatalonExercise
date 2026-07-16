package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.assertj.core.api.InstanceOfAssertFactories.BYTE

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

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

public class LoginPage extends BasePage {
	private By loginTitle = By.cssSelector("div.login-form h2")
	private By loginEmailInput = By.cssSelector("input[data-qa='login-email']")
	private By loginPasswordInput = By.cssSelector("input[data-qa='login-password']")
	private By loginBtn = By.cssSelector("button[data-qa='login-button']")
	private By errorMessage = By.cssSelector("form[action='/login'] p")
	private By signupNameInput = By.cssSelector("input[data-qa='signup-name']")
	private By signupEmailInput = By.cssSelector("input[data-qa='signup-email']")
	private By signUpButton = By.cssSelector("button[data-qa='signup-button']")
	LoginPage verifyLoginTitle (String expectedTitle) {
		waitVisible(loginTitle)
		assert getText(loginTitle).equals(expectedTitle)
		return this
	}
	LoginPage setLoginEmailInput(String email) {
		setText(loginEmailInput, email)
		return this
	}
	LoginPage setLoginPasswordInput (String password) {
		setText(loginPasswordInput, password)
		return this
	}
	LoginPage setSignupNameInput (String name) {
		setText(signupNameInput, name)
		return this
	}
	LoginPage setSignupEmailInput (String email) {
		setText(signupEmailInput, email)
		return this
	}
	LoginPage clickOnLoginButton () {
		click(loginBtn)
		return this
	}
	SignUpPage clickOnSignupButton () {
		click(signUpButton)
		return new SignUpPage()
	}
	LoginPage verifyErrorMessage(String expectedMessage) {
		assert getText(errorMessage).equals(expectedMessage)
		return this
	}
	
}
