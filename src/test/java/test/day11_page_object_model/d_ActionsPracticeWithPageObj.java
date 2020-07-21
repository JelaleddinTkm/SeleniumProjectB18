package test.day11_page_object_model;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;
import utilities.Driver;

public class d_ActionsPracticeWithPageObj {

    @Test
    public void tc15_hover_over_test() throws InterruptedException {

        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        HoversPage hoversPage = new HoversPage();
        Actions actions = new Actions(Driver.getDriver());

        //2. Hover over to first image
        Thread.sleep(3000);
        actions.moveToElement(hoversPage.img1).perform();

        //3. Assert:
        // a. "name: user1" is displayed
        Assert.assertTrue(hoversPage.user1.isDisplayed());

        //4. Hover over to second image
        Thread.sleep(3000);
        actions.moveToElement(hoversPage.img2).perform();

        //5. Assert:
        // a. "name: user2" is displayed
        Assert.assertTrue(hoversPage.user2.isDisplayed());

        //6. Hover over to third image
        Thread.sleep(3000);
        actions.moveToElement(hoversPage.img3).perform();

        //7. Confirm:
        // a. "name: user3" is displayed
        Assert.assertTrue(hoversPage.user3.isDisplayed());

    }


}
