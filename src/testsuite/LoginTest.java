package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void openBrowser(){
        setUpBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
//Enter “standard_user” username
       sendTextToElement((By.id("user-name")),"standard_user");
//Enter “secret_sauce” password
        sendTextToElement((By.id("password")),"secret_sauce");
//Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
//Verify the text “PRODUCTS
        String expectedText = "PRODUCTS";
        verifyTextWithAssert("PRODUCTS",((By.xpath("//span[contains(text(),'Products')]"))),"text not displayed");

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
    sendTextToElement((By.id("user-name")),"standard_user");
//Enter “secret_sauce” password
    sendTextToElement((By.id("password")),"secret_sauce");
//Click on ‘LOGIN’ button
        clickOnElement((By.id("login-button")));
//Verify that six products are displayed on page and store in List webelement
     List<WebElement> productsList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
     // to check how many products are,use size method
        int actualNumOfProducts = productsList.size();
        System.out.println(actualNumOfProducts);
        int expectedNoOfProducts = 6;
        Assert.assertEquals(expectedNoOfProducts,actualNumOfProducts);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
