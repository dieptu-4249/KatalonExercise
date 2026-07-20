import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import pages.HomePage
import pages.TestCasesPage

//1. Launch browser
WebUI.openBrowser('')
HomePage homePage = new HomePage()

//2. Navigate to url 'http://automationexercise.com'
homePage.open()

//3. Verify that home page is visible successfully
homePage.verifyVisible()

//4. Click on 'Test Cases' button
TestCasesPage testCasesPage = homePage.clickOnTestCases()

//5. Verify user is navigated to test cases page successfully
testCasesPage.verifyVisible()
WebUI.closeBrowser()
