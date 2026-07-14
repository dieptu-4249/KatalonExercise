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
import pages.HomePage
import pages.ProductPage

import org.openqa.selenium.Keys as Keys

//1. Launch browser
WebUI.openBrowser("")
HomePage homePage = new HomePage()
//2. Navigate to url 'http://automationexercise.com'
homePage.open()
//3. Verify that home page is visible successfully
homePage.verifyHomePageVisible()
//4. Click on 'Products' button
ProductPage productPage = homePage.clickOnProduct()
//5. Verify user is navigated to ALL PRODUCTS page successfully
productPage.verifyAllProductsPageVisible("ALL PRODUCTS")
//6. Enter product name in search input and click search button
String searchKeyword = "little"
// in-case: keyword = 's' -> blue top failed case
productPage.setSearchInput(searchKeyword)
productPage.clickOnSearchSubmitButton()
//7. Verify 'SEARCHED PRODUCTS' is visible
productPage.verifySearchedProductsPageVisible("SEARCHED PRODUCTS")
//8. Verify all the products related to search are visible
productPage.verifySearchedProducts(searchKeyword)
WebUI.closeBrowser()

