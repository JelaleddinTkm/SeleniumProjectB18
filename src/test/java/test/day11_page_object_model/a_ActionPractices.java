package test.day11_page_object_model;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.Driver;

public class a_ActionPractices {

    Actions actions;

    @Ignore
    @Test
    public void scrolling_with_actions() throws InterruptedException {

        //get our page
        Driver.getDriver().get("http://practice.cybertekschool.com/");

        //creating actions instance to be able to use its methods
            actions = new Actions( Driver.getDriver() );

        //locating the web element we want to scroll to
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement inputs = Driver.getDriver().findElement(By.linkText("Inputs"));

        Thread.sleep(3000);

        //using actions instance we use moveToElement method
            actions.moveToElement(cybertekSchoolLink).perform();

        Thread.sleep(3000);
            actions.moveToElement(inputs).perform();


    }


    //own practice
    @Ignore
    @Test
    public void scrollingWithActions() throws InterruptedException {

        Driver.getDriver().get("http://practice.cybertekschool.com/");

        actions = new Actions(Driver.getDriver());

        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        actions.moveToElement(cybertekSchoolLink).perform();

        Thread.sleep(1000);
        WebElement frameslLink = Driver.getDriver().findElement(By.linkText("Frames"));
        actions.moveToElement(frameslLink).perform();

    }


//----------------------------------------------------------------------------------


    @Ignore
    @Test
    public void tc16_double_click_test() {

        //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //2. Switch to iframe.
        //we can switch to by 1-index, 2- id-name, 3- locate  it as a webElement and pass it
        Driver.getDriver().switchTo().frame("iframeResult");

        //3. Double click on the text "Double-click me to change my text color."
        WebElement textToDoubleClick = Driver.getDriver().findElement(By.id("demo"));

        actions = new Actions(Driver.getDriver());
        actions.doubleClick(textToDoubleClick).perform();


        //4. Assert: Text's "style" attribute value contains "red".
        String actual = textToDoubleClick.getAttribute("style");
        String expected = "color: red;";

        Assert.assertTrue(actual.equals(expected));


    }


    //own practice
    @Ignore
    @Test
    public void tc16_doubleClick() {

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //switch to iframe
        Driver.getDriver().switchTo().frame("iframeResult");

        //double click on the text
       WebElement textToDoubleClick = Driver.getDriver().findElement(By.id("demo"));

        actions = new Actions(Driver.getDriver());
        actions.doubleClick(textToDoubleClick).perform();

        //Assert: text "style" attribute value contains "red"
        String actual = textToDoubleClick.getAttribute("style");
        String expected = "color: red;";

        Assert.assertTrue(actual.equals(expected));


    }


//----------------------------------------------------------------------------------


    @Ignore
    @Test
    public void tc17_drag_and_drop_test() throws InterruptedException {

        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //2. Drag and drop the small circle to bigger circle.

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        //using actions instance to do drag and drop
        actions = new Actions(Driver.getDriver());

        actions.clickAndHold(smallCircle).moveToElement(bigCircle).perform();

        String expectedWhileHover = "Now drop...";
        String actualWhileHover = bigCircle.getText();

        Assert.assertEquals(actualWhileHover, expectedWhileHover);

        Thread.sleep(2000);

        actions.release().perform();

        //actions.dragAndDrop(smallCircle, bigCircle).perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String actual = bigCircle.getText();
        String expected = "You did great!";

        Assert.assertEquals(actual, expected);

    }


    //own practice
    @Ignore
    @Test
    public void tc17_dragAndDrop() {

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //2. Drag and drop the small circle to bigger circle.
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        actions = new Actions(Driver.getDriver());

        //actions.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();

        actions.dragAndDrop(smallCircle, bigCircle).perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String actualText = bigCircle.getText();
        String expectdText = "You did great!";

        Assert.assertTrue(actualText.equals(expectdText));

    }



//----------------------------------------------------------------------------------


    @Ignore
    @Test
    public void tc18_right_click_test() {

        //1. Go to https://the-internet.herokuapp.com/context_menu
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        //2. Right click to the box.
        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));

        actions = new Actions(Driver.getDriver());

        actions.contextClick(box).perform();


        //3. Alert will open.
        Alert alert = Driver.getDriver().switchTo().alert();

        //4. Accept alert
        alert.accept();

        //No assertion needed for this practice.
    }


    //own practice
    @Test
    public void tc18_rightClick() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        //2. right click to the box
        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));

        actions = new Actions(Driver.getDriver());
        actions.contextClick(box).perform();

        //3. Alert will open
        Alert alert = Driver.getDriver().switchTo().alert();

        //4. Accept alert
        alert.accept();

    }



}
