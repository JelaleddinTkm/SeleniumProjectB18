package test.day04_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P05_Checkbox_Task {

    public static void main(String[] args) throws InterruptedException {

        //TC #2: SeleniumEasy Checkbox Verification – Section 1
        //1. Open Chrome browser
        //2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //3. Verify “Success – Check box is checked” message is NOT displayed.
        WebElement successCheckBox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));

        if(!successCheckBox.isSelected() && !successMessage.isDisplayed()){
            System.out.println("Default value verification PASSED!");
        }else {
            System.out.println("Default value verification FAILED!");
        }


        //4. Click to checkbox under “Single Checkbox Demo” section
        Thread.sleep(3000);
        successCheckBox.click();

        //5. Verify “Success – Check box is checked” message is displayed.
        if(successMessage.isDisplayed()){
            System.out.println("Success message is displayed! PASSED!");
        }else {
            System.out.println("Success message is NOT displayed! FAILED!");
        }


        /*
        Default value verification PASSED!
        Success message is displayed! PASSED!

         */

    }
}
