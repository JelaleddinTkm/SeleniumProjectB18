package test.day09_testbase_properties_driverUtil;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.base.TestBase;
import utilities.WebDriverFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlePractice extends TestBase {


    @Test
    public void multiple_window_test() {

        driver .get("htps://www.amazon.com");

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);


        // we are downcasting our driver to JavaScriptExecuter to be able to use its methods
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");


        //5.create a logic to swich to the tab where Etsy.com open
        Set<String> windowHandles = driver.getWindowHandles();

        for(String each : windowHandles){
            driver.switchTo().window(each);
            System.out.println( "current title: " + driver.getTitle() );

        //6. Assert: Title contains "Etsy"
            if(driver.getCurrentUrl().contains("etsy")){
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }

    }







}
