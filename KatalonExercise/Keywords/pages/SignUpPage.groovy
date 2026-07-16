package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select

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

public class SignUpPage extends BasePage {
	private By passwordInput = By.cssSelector("input#password")
	private By dayDropdown = By.id("days")
	private By monthDropdown = By.id("months")
	private By yearDropdown = By.id("years")
	private By firstNameInput = By.id("first_name")
	private By lastNameInput = By.id("last_name")
	private By companyInput = By.id("company")
	private By address1Input = By.id("address1")
	private By address2Input = By.id("address2")
	private By countryDropdown = By.id("country")
	private By stateInput = By.id("state")
	private By cityInput = By.id("city")
	private By zipcodeInput = By.id("zipcode")
	private By mobileNumberInput = By.id("mobile_number")
	private By createAccountButton = By.cssSelector("button[data-qa='create-account']")
	

	private By genderRadio(int genderId) {
		return By.cssSelector("div.clearfix div#uniform-id_gender${genderId}")
	}
	SignUpPage selectGender(int genderId) {
		click(genderRadio(genderId))
		return this
	}
	
	SignUpPage selectDay(String day) {
		Select select = new Select(find(dayDropdown))
		select.selectByValue(day)
		return this
	}
	
	SignUpPage selectMonth(String month) {
		Select select = new Select(find(monthDropdown))
		select.selectByValue(month)
		return this
	}
	
	SignUpPage selectYear(String year) {
		Select select = new Select(find(yearDropdown))
		select.selectByValue(year)
		return this
	}
	SignUpPage enterPassword(String password) {
		setText(passwordInput, password)
		return this
	}
	SignUpPage enterFirstName(String firstName) {
		setText(firstNameInput, firstName)
		return this
	}
	SignUpPage enterLastName(String lastName) {
		setText(lastNameInput, lastName)
		return this
	}
	SignUpPage enterCompany(String company) {
		setText(companyInput, company)
		return this
	}
	SignUpPage enterAddress1(String address1) {
		setText(address1Input, address1)
		return this
	}
	SignUpPage enterAddress2(String address2) {
		setText(address2Input, address2)
		return this
	}
	SignUpPage enterState(String state) {
		setText(stateInput, state)
		return this
	}
	SignUpPage enterCity(String city) {
		setText(cityInput, city)
		return this
	}
	SignUpPage enterZipcode(String zipcode) {
		setText(zipcodeInput, zipcode)
		return this
	}
	SignUpPage enterMobileNumber(String mobileNumber) {
		setText(mobileNumberInput, mobileNumber)
		return this
	}
	SignUpPage selectCountry(String country) {
		Select select = new Select(find(countryDropdown))
		select.selectByVisibleText(country)
		return this
	}
	AccountCreatedPage clickCreateAccount() {
		click(createAccountButton)
		return new AccountCreatedPage()
	}
	
	
	
}
