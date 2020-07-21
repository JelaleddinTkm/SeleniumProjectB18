package test.day04_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P06_Checkbox_Task {

    public static void main(String[] args) {

        //TC #3: SeleniumEasy Checkbox Verification – Section 2
        //1. Open Chrome browser
        //2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html

        //WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //3. Verify “Check All” button text is “Check All”


        WebElement checkAll = driver.findElement(By.xpath("//input[@value='Check All']"));


            if(checkAll.isDisplayed()){
                System.out.println("Check All text displayed, PASSED!");
            }else {
                System.out.println("Check All text NOT displayed, FAILED!");
            }


        //4. Click to “Check All” button
        checkAll.click();


        //5. Verify all check boxes are checked

        if(driver.findElement(By.xpath("(//input[@class='cb1-element'])[1]")).isSelected() && driver.findElement(By.xpath("(//input[@class='cb1-element'])[2]")).isSelected() && driver.findElement(By.xpath("(//input[@class='cb1-element'])[3]")).isSelected() && driver.findElement(By.xpath("(//input[@class='cb1-element'])[4]")).isSelected()){

            System.out.println("All boxes are selected, PASSED!");
        }else {
            System.out.println("All boxes are NOT selected, FAILED!");
        }

        //6. Verify button text changed to “Uncheck All”
        WebElement unCheckAll = driver.findElement(By.xpath("//input[@value='Uncheck All']"));
        if(unCheckAll.isDisplayed()){
            System.out.println("Check All button changed to Uncheck All, PASSED!");
        }else {
            System.out.println("Check All button NOT changed to Uncheck All, FAILED!");
        }


        /*
        Check All text displayed, PASSED!
        All boxes are selected, PASSED!
        Check All button changed to Uncheck All, PASSED!
         */



    }
}
