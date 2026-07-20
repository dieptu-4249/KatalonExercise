import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import pages.CartPage
import pages.HomePage

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
homePage.addRandomRecommendedItemToCart()

//6. Click on 'View Cart' button
CartPage cartPage = homePage.clickOnViewCart()

//7. Verify that product is displayed in cart page
String selectedPName = homePage.getSelectedRecommendedProductName()
cartPage.verifySelectedProductInCart(selectedPName)
WebUI.closeBrowser()
