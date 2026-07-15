import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import pages.CheckoutPage
import pages.HomePage

import org.openqa.selenium.Keys as Keys


//1. Launch browser
WebUI.openBrowser("")
//2. Navigate to url 'http://automationexercise.com'
HomePage homePage = new HomePage()
homePage.open()
//3. Scroll to bottom of page
homePage.scrollToRecommendedTitle()
//4. Verify 'RECOMMENDED ITEMS' are visible
homePage.verifyRecommendedTitleVisible()
//5. Click on 'Add To Cart' on Recommended product
homePage.clickOnRandomRecommendedItem()
//6. Click on 'View Cart' button
CheckoutPage checkoutPage = homePage.clickOnViewCart()
//7. Verify that product is displayed in cart page
String selectedPName = homePage.getSelectedRecommendedProductName()
checkoutPage.verifySelectedProductInCart(selectedPName)
WebUI.closeBrowser()

