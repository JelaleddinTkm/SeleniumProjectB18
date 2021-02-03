package test.OfficeHour_day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class June24 {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void classSetup() {
        System.out.println("Some class setup");
    }

    //to run before every test method
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();              //to open chrome browser for test
        softAssert = new SoftAssert();
    }

    @Test(description = "Test for Google", priority = 1)
    public void test() {

        driver.get("http://google.com");
        //soft assertions
        softAssert.assertEquals(driver.getTitle(), "Google23");
        softAssert.assertEquals(driver.getTitle(), "Google21");
        softAssert.assertEquals(driver.getTitle(), "Google1231");

        System.out.println("Page title :: " + driver.getTitle());

        //enter Java and hit enter button
        driver.findElement(By.name("q")).sendKeys("Java", Keys.ENTER);
        WebElement results = driver.findElement(By.id("result-stats"));

        System.out.println(results.getText());
        //let's make sure that every single search result contains "Java"

        List<WebElement> searchResults = driver.findElements(By.tagName("h3"));
        searchResults.removeIf(item -> item.getText().isEmpty());

        for (WebElement searchResult : searchResults) {
            System.out.println("Search result :: " + searchResult.getText());
            softAssert.assertTrue(searchResult.getText().contains("Java"));
        }
        softAssert.assertAll();//regardless on miss matching assertions, test execution will continue until this point
    }



    @Test(description = "Test for Amazon", priority = 2)
    public void amazonTest() {

        driver.get("http://amazon.com");
        System.out.println("Before assertion");                   // Before assertion

        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        System.out.println("After assertion");                    // After assertion
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}






