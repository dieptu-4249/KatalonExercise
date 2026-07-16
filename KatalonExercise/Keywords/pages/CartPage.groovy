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

public class CartPage extends BasePage {
	private By productNames = By.cssSelector("tr td.cart_description a")
	private By breadcrumbShoppingCart = By.cssSelector("div.breadcrumbs li.active")
	private By checkoutButton = By.cssSelector("a.check_out")
	private By registerLoginButtonInModal = By.cssSelector("div.modal-body a[href='/login']")
	//private By descriptionTextarea = By.cssSelector("#ordermsg textarea")
	
	CartPage verifySelectedProductInCart (String selectedProductName) {
		verifyVisible(productNames)
		def productNamesInCart = finds(productNames).collect { it.getText() }
		assert productNamesInCart.contains(selectedProductName)
		return this
		
	}
	CartPage verifyCartPageVisible() {
		verifyVisible(breadcrumbShoppingCart)
		assert getText(breadcrumbShoppingCart) == "Shopping Cart"
		return this
	}
	CheckoutPage clickOnCheckout () {
		click(checkoutButton)
		return new CheckoutPage()
	}
	LoginPage clickOnRegisterLoginInModal() {
		click(registerLoginButtonInModal)
		return new LoginPage()
	}
	

}
