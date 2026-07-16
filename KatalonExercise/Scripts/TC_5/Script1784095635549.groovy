import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.katalon.webui.keyword.action.image.WebUIAbstractImageActionKeyword
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
import pages.AccountCreatedPage
import pages.CartPage
import pages.CheckoutPage
import pages.HomePage
import pages.LoginPage
import pages.OrderPlacedPage
import pages.PaymentPage
import pages.SignUpPage

import org.openqa.selenium.Keys as Keys

//1. Launch browser
WebUI.openBrowser("")
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully

HomePage homePage = new HomePage()
homePage.open().verifyHomePageVisible()
//4. Add products to cart
homePage.clickOnRandomFeatureItems(3)
//5. Click 'Cart' button
CartPage  cartPage = homePage.clickOnCartButton()
//6. Verify that cart page is displayed
cartPage.verifyCartPageVisible()
//7. Click Proceed To Checkout
cartPage.clickOnCheckout()
//8. Click 'Register / Login' button
LoginPage loginPage = cartPage.clickOnRegisterLoginInModal()
//9. Fill all details in Signup and create account
loginPage.setSignupNameInput("meomeo")
loginPage.setSignupEmailInput("meomeo143@gmail.com")
SignUpPage signUpPage = loginPage.clickOnSignupButton()
String userName = "meomeo"
String firstName = "Tu"
String lastName = "Nguyen"
String company = "ABC Company"
String address1 = "123 Nguyen Van Linh"
String address2 = "District 7"
String country = "India"
String state = "Ho Chi Minh"
String city = "Ho Chi Minh City"
String zipcode = "700000"
String mobile = "0912345678"
AccountCreatedPage accountCreatedPage = signUpPage
.selectGender(1)
.enterPassword("123456")
.selectDay("15")
.selectMonth("5")
.selectYear("1998")
.enterFirstName(firstName)
.enterLastName(lastName)
.enterCompany(company)
.enterAddress1(address1)
.enterAddress2(address2)
.selectCountry(country)
.enterState(state)
.enterCity(city)
.enterZipcode(zipcode)
.enterMobileNumber(mobile)
.clickCreateAccount()
//10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
accountCreatedPage.verifyAccountCreatedPageVisible()
HomePage homePage2 = accountCreatedPage.clickOnContinueButton()
println(homePage2)
//11. Verify ' Logged in as username' at top
homePage2.verifyLoggedInfoVisible()

// Part 2
//12.Click 'Cart' button
CartPage cartPage2 = homePage2.clickOnCartButton()
//13. Click 'Proceed To Checkout' button
CheckoutPage checkoutPage = cartPage2.clickOnCheckout()
//14. Verify Address Details and Review Your Order
checkoutPage.verifyAddressDetailsTitleVisible()
checkoutPage.verifyReviewOrderTitle()
//15. Enter description in comment text area and click 'Place Order'
checkoutPage.setDescriptionOrder("mua cho meomeo")
PaymentPage paymentPage = checkoutPage.clickOnPlaceOrder()
//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
paymentPage.setCardNameInput("ACB").setCardNumberInput("000099887766").setCvcInput("333").setExpireMonthInput("4").setExpireYearInput("2026")
//17. Click 'Pay and Confirm Order' button
paymentPage.clickOnPayAndConfirmButton()
//18. Verify success message 'Your order has been placed successfully!'
//paymentPage.verifyOrderPlacedSuccessfully()
OrderPlacedPage orderPlacedPage = paymentPage.waitForRedirectToOrderPlacedPage()
//19. Click 'Download Invoice' button and verify invoice is downloaded successfully.

//20. Click 'Continue' button
//21. Click 'Delete Account' button
//22. Verify 'ACCOUNT DELETED!' and click 'Continue' button


WebUI.closeBrowser()
