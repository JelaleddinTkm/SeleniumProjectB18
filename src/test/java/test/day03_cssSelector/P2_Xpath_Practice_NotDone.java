package test.day03_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class P2_Xpath_Practice_NotDone {

    public static void main(String[] args) throws InterruptedException {

        //TC #2:
        // PracticeCybertek.com_AddRemoveElements WebElement verification
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/add_remove_elements/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementButton.click();

        Thread.sleep(3000);

        //4. Verify “Delete” button is displayed after clicking.
        if( addElementButton.isDisplayed() ) {
            System.out.println("Delete button is Displayed!");
        }else {
            System.out.println("Delete button is NOT Displayed!!!");
        }

        //5. Click to “Delete” button.
        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        deleteButton.click();


//        // ........I COULD  NOT PASS THIS 6TH STEP.......
//        //6. Verify “Delete” button is NOT displayed after clicking.
//        if(deleteButton.isDisplayed()) {
//            System.out.println("Delete button is displayed, verification Failed!!!");
//
//        }else {
//            System.out.println("Delete button is NOT displayed, verification Passed!");
//        }
//        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    }
}
