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
import pages.LoginPage

import org.openqa.selenium.Keys as Keys
WebUI.openBrowser("")
//1. Launch browser
HomePage homePage = new HomePage()
//2. Navigate to url 'http://automationexercise.com'
homePage.open()
//3. Verify that home page is visible successfully
homePage.verifyHomePageVisible("Automation Exercise")
//4. Click on 'Signup / Login' button
LoginPage loginPage = homePage.clickOnSignUpLogin()
//5. Verify 'Login to your account' is visible
loginPage.verifyLoginTitle("Login to your account")
//6. Enter incorrect email address and password
loginPage.setEmailInput("dieptu@gmail.com")
loginPage.setPasswordInput("1234")
//7. Click 'login' button
loginPage.clickLoginButton()
//8. Verify error 'Your email or password is incorrect!' is visible
loginPage.verifyErrorMessage("Your email or password is incorrect!")
WebUI.closeBrowser()

