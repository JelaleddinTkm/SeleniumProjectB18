package test.day07_javafaker_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class task3_select {


    WebDriver driver;


    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }


    @BeforeMethod
    public void setUp(){
        //TC#1: Verifying "Simple dropdown" and "State selection" dropdown default values
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void task3_select_date_test() {

    //   Select "December 1 , 1921" and verify it is selected.

    //   Select year using : visible text

        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearDropdown.selectByVisibleText("1921");

        String yearActual = yearDropdown.getFirstSelectedOption().getText();
        String yearExpected = "1921";

        //Asserting year dropdown values vs expected
        Assert.assertEquals(yearActual, yearExpected);


    //   Select month using : value attribute

        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropdown.selectByValue("11"); //--> will select December using attribute value

        String monthActual = monthDropdown.getFirstSelectedOption().getText();
        String monthExpected = "December";

        //Asserting month dropdown values vs expected
        Assert.assertEquals(monthActual, monthExpected);


    //   Select day using: index number

        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(0);

        String dayActual = dayDropdown.getFirstSelectedOption().getText();
        String dayExpected = "1";

        //Asserting day dropdown values vs expected
        Assert.assertTrue(dayActual.equals(dayExpected));



        /*

        ===============================================
        Default Suite
        Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
        ===============================================

         */




    }

}
