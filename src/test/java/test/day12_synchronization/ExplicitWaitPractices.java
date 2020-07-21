package test.day12_synchronization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1Page;
import pages.Loading7Page;
import utilities.Driver;

public class ExplicitWaitPractices {

    /*
    TC#40:
    Dynamically Loaded Page Elements 7

    1.Go to http://practice.cybertekschool.com/dynamic_loading/7
    2.Wait until title is “Dynamic Title”
    3.Assert : Message “Done” is displayed.
    4.Assert : Image is displayed.

    Note: Follow POM (Project Oriented Module)
     */

    @Test
    public void tc40_dynamic_title_test() {

        // 1.Go to http://practice.cybertekschool.com/dynamic_loading/7
        String url = "http://practice.cybertekschool.com/dynamic_loading/7";
        Driver.getDriver().get(url);

        Loading7Page loading7Page = new Loading7Page();  // HERE we created new frame

        //2.Wait until title is “Dynamic Title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        //we are using the object to set up our EXPECTED CONDITION
        String expectedTitleToBe = "Dynamic title";
        wait.until(ExpectedConditions.titleIs(expectedTitleToBe));

        //3.Assert : Message “Done” is displayed
        Assert.assertTrue(loading7Page.doneMessage.isDisplayed());

        // 4.Assert : Image is displayed
        Assert.assertTrue(loading7Page.spongeBobImage.isDisplayed());

    }



//--------------------------------------------------------------------------------



    /*

TC#41:
Dynamically Loaded Page Elements 1
1.Go to http://practice.cybertekschool.com/dynamic_loading/1
2.Click to start
3.Wait until loading bar disappears
4.Assert username inputboxis displayed
5.Enter username: tomsmith
6.Enter password: incorrectpassword
7.Click to Submit button
8.Assert "Your username is invalid!" text is displayed.

     */

    @Test
    public void tc41_dynamic_form_test() {

        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        Loading1Page loading1Page = new Loading1Page();

        loading1Page.startButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        wait.until(ExpectedConditions.invisibilityOf(loading1Page.loadingBar));

        Assert.assertTrue(loading1Page.usernameInput.isDisplayed(), "Username input box is not displayed!");

        loading1Page.usernameInput.sendKeys("tomsmith");
        loading1Page.passwordInput.sendKeys("alklljlsd");
        loading1Page.submitButton.click();

        Assert.assertTrue(loading1Page.errorMessage.isDisplayed());





    }






}
