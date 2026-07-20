import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import pages.HomePage
import pages.ProductPage

//1. Launch browser
WebUI.openBrowser('')
HomePage homePage = new HomePage()

//2. Navigate to url 'http://automationexercise.com'
homePage.open()

//3. Verify that home page is visible successfully
homePage.verifyVisible()

//4. Click on 'Products' button
ProductPage productPage = homePage.clickOnProduct()
productPage.verifyProductListNameVisible()

//6. Enter product name in search input and click search button
// in-case: keyword = 's' -> blue top failed case
// gom 2 step thanh searchProduct
productPage.searchProducts()

//7. Verify 'SEARCHED PRODUCTS' is visible
productPage.verifySearchedProductListNameVisible()

//8. Verify all the products related to search are visible
productPage.verifySearchedProducts()
WebUI.closeBrowser()
