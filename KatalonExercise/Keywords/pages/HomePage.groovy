package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.ivy.core.module.descriptor.ExtendsDescriptor
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

public class HomePage extends BasePage {
	private By btnSignUpLogin = By.cssSelector("a[href='/login']");
	private By testCasesButton = By.cssSelector("li a[href='/test_cases']")
	private By slider = By.cssSelector("div[id='slider-carousel']")
	private By productButton = By.cssSelector("li a[href='/products']")
	private By recommendedTitle = By.cssSelector(".recommended_items h2.title")
	private By recommendedProducts = By.cssSelector(".recommended_items .item.active .productinfo.text-center")
	private By viewCartButton = By.cssSelector(".modal-body a")
	private String selectedRecommendedProductName = ""
	
	String getSelectedRecommendedProductName () {
		return this.selectedRecommendedProductName
	}
	HomePage open () {
		goToUrl("http://automationexercise.com")
		return this
	}
	HomePage verifyHomePageVisible () {
		verifyVisible(slider)
		return this
	}
	HomePage scrollToRecommendedTitle() {
		scrollToElement(recommendedTitle)
		return this
	}
	HomePage verifyRecommendedTitleVisible() {
		verifyVisible(recommendedTitle)
		return this
	}
	HomePage clickOnRandomRecommendedItem() {
		def products = finds(recommendedProducts)
		def randomIndex = new Random().nextInt(products.size())
		def selectedProduct = products[randomIndex]
		selectedRecommendedProductName = selectedProduct.findElement(By.tagName("p")).getText()
		selectedProduct.findElement(By.cssSelector("a.add-to-cart")).click()				
		return this
	}
	CheckoutPage clickOnViewCart() {
		click(viewCartButton)
		return new CheckoutPage()
	}

	LoginPage clickOnSignUpLogin() {
		click(btnSignUpLogin)
		return new LoginPage()
	}
	TestCasesPage clickOnTestCases() {
		click(testCasesButton)
		return new TestCasesPage()
	}
	ProductPage clickOnProduct() {
		println(driver.getCurrentUrl())
		click(productButton)
		return new ProductPage()
	}
}
