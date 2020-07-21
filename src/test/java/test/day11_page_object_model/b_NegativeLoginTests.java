package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class b_NegativeLoginTests {


    LoginPage loginPage;


    @Ignore
    @Test
    public void tc30_negative_login_test() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        WebElement usernameInput = Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement passwordInput = Driver.getDriver().findElement(By.id("prependedInput2"));
        WebElement loginButton = Driver.getDriver().findElement(By.id("_submit"));

        String username = ConfigurationReader.getProperty("storemanager_username");

        usernameInput.sendKeys(username);

        Thread.sleep(3000);

        passwordInput.sendKeys("lkjzdhvalk");

        loginButton.click();

        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));

        Assert.assertTrue(errorMessage.isDisplayed(), "Assert message is NOT displayed");


    }

    //own practice
    @Ignore
    @Test
    public void tc30_negativeLogin() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        WebElement usernameInput = Driver.getDriver().findElement(By.id("prependedInput"));
        usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager_username"));

        WebElement passwordInput = Driver.getDriver().findElement(By.id("prependedInput2"));
        passwordInput.sendKeys("sdfls"); //barlap gormek ucin rasgele bir password yazyp goryas
        //passwordInput.sendKeys(ConfigurationReader.getProperty("storemanager_password"));

        Driver.getDriver().findElement(By.id("_submit")).click();

        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is NOT displayed!");


    }



    //---------------------------------------------------------------------------



    @Ignore
    @Test
    public void negative_login_test_with_page_object() {

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        loginPage = new LoginPage();

        //sending username
        String username = ConfigurationReader.getProperty("storemanager_username");

        loginPage.usernameInput.sendKeys(username);

        //send our incorrect password
        loginPage.passwordInput.sendKeys("jaksddfh");

        //click using our loginpage object
        loginPage.loginButton.click();

        //asserting error message IS DISPLAYED
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        //asserting the TEXT VALUE of the error message
        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";

        Assert.assertEquals(actualText, expectedText);



    }



    //---------------------------------------------------------------------------



    @Ignore
    @Test
    public void tc31_wrong_username_test() {

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        loginPage = new LoginPage();

        String username = "lsdfjlsk";
        String password = ConfigurationReader.getProperty("storemanager_password");

        loginPage.login(username, password);

        //Asserting error message IS DISPLAYED
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        //Asserting the TEXT VALUE of the error message
        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";

        Assert.assertEquals(actualText, expectedText);

    }


    //own parctice
    @Ignore
    @Test
    public void tc31_wrongUsername() {

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        loginPage = new LoginPage();

        String wrongUsername = "kslfsf";
        String actualPassword = ConfigurationReader.getProperty("storemanager_password");

        loginPage.login(wrongUsername,actualPassword);

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";
        Assert.assertEquals(actualText,expectedText);
    }









}
