import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import pages.HomePage
import pages.LoginPage

//1. Launch browser
WebUI.openBrowser('')
HomePage homePage = new HomePage()

//2. Navigate to url 'http://automationexercise.com'
homePage.open()

//3. Verify that home page is visible successfully
homePage.verifyVisible()

//4. Click on 'Signup / Login' button
LoginPage loginPage = homePage.clickOnSignUpLogin()

//5. Verify 'Login to your account' is visible
loginPage.verifyLoginTitle('Login to your account')

//6. Enter incorrect email address and password
loginPage.enterLoginEmail('dieptu@gmail.com')
loginPage.enterLoginPassword('1234')

//7. Click 'login' button
loginPage.clickOnLoginButton()

//8. Verify error 'Your email or password is incorrect!' is visible
loginPage.verifyErrorMessage()
WebUI.closeBrowser()

