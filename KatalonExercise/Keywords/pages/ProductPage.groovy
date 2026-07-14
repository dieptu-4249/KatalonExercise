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

public class ProductPage extends BasePage{
	private By productsTitle = By.cssSelector("h2.title")
	private By searchProductInput = By.cssSelector("input[id='search_product']")
	private By searchSubmitButton = By.cssSelector("button[id='submit_search']")
	private By productCard = By.cssSelector("div[class='productinfo text-center'] p")
	ProductPage verifyAllProductsPageVisible(String allProductsTitle) {
		verifyVisible(searchProductInput)
		assert getText(productsTitle).equals(allProductsTitle)
		return this
	}
	ProductPage verifySearchedProductsPageVisible(String searchedProductsTitle) {
		assert getText(productsTitle).equals(searchedProductsTitle)
		return this
	}

	ProductPage setSearchInput(String searchKeyword) {
		setText(searchProductInput, searchKeyword)
		return this
	}
	ProductPage clickOnSearchSubmitButton() {
		click(searchSubmitButton)
		return this
	}
	ProductPage verifySearchedProducts(String searchKeyword) {
		searchKeyword = searchKeyword.toLowerCase()
		List<String> productNames = driver.findElements(productCard).collect { it.getText() }
		productNames.each {  name ->
			assert name.toLowerCase().contains(searchKeyword)
		}
		return this
	}
}
