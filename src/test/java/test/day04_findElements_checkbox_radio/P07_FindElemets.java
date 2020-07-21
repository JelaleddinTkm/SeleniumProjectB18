package test.day04_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class P07_FindElemets {

    public static void main(String[] args) throws InterruptedException {

        //TC #3:
        // PracticeCybertek.com_AddRemoveElements WebElement verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //2. Go to http://practice.cybertekschool.com/add_remove_elements
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        //3. Click to “Add Element” button 50 times
        WebElement addElement = driver.findElement(By.xpath("//button[@oneclick='addElement()']"));

        for(int i=1; i<=50; i++){
         Thread.sleep(1000);
            addElement.click();
        }

        //4. Verify 50 “Delete” button is displayed after clicking.
        List<WebElement> deleteList= driver.findElements(By.xpath("//button[@class='added-manually']"));

        if(deleteList.size() == 50){
            System.out.println("Delete button is displayed 50 times after clicking, PASSED!");
        }else {
            System.out.println("Delete button is NOT displayed 50 times after clicking, FAILED");
        }


        //5. Click to ALL “Delete” buttons to delete them.
        for(int i=0; i<deleteList.size(); i++) {
            Thread.sleep(1000);
            deleteList.get(i).click();
        }

        Thread.sleep(2000);

        //6. Verify “Delete” button is NOT displayed after clicking.
        WebElement body = driver.findElement(By.xpath("//body//a"));

            if(!body.getText().contains("delete")){
            System.out.println("Delete button is NOT displayed after clicking, PASSED!");
        }else {
            System.out.println("Delete button is displayed after clicking, FAILED");
        }
            driver.close();

        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS Hint: Need to use findElements method.
    }
}
