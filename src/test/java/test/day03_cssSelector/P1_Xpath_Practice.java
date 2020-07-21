package test.day03_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P1_Xpath_Practice {

    public static void main(String[] args) {


        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/forgot_password

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH locator only (total of 6)
        //a. “Home” link
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        if( homeLink.isDisplayed() ) {
            System.out.println("Home link verification Passed!");
        }else {
            System.out.println("Home link verification Failed !!!");
        }

        //b. “Forgot password” header
        WebElement header = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        if( header.isDisplayed() ) {
            System.out.println("Forgot password header verification Passed!");
        }else {
            System.out.println("Forgot password header verification Failed!!!");
        }

        //c. “E-mail” text
        WebElement emailText =
                driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']//following::label"));
        if( emailText.isDisplayed() ) {
            System.out.println("E-mail text verification Passed!");
        }else {
            System.out.println("E-mail text verification Failed!!!");
        }

        //d. E-mail input box
        WebElement emailInputBox =
                driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']//following::input"));
        if( emailInputBox.isDisplayed() ) {
            System.out.println("E-mail input box verification Passed!");
        }else {
            System.out.println("E-mail input box verification Failed!!!");
        }

        //e. “Retrieve password” button
        WebElement retrievePasswordButton = driver.findElement(By.xpath("//i[contains(text(), 'Retrieve')]"));
        if( retrievePasswordButton.isDisplayed() ) {
            System.out.println("Retrieve password button verification Passed!");
        }else {
            System.out.println("Retrieve password button verification Failed!!!");
        }

        //f. “Powered by Cybertek School” text
        WebElement poweredByText = driver.findElement(By.xpath("//div[contains(text(), 'Powered')]"));
        if( poweredByText.isDisplayed() ) {
            System.out.println("Powered by Cybertek School text verification Passed!");
        }else {
            System.out.println("Powered by Cybertek School text verification Failed!!!");
        }

        //4. Verify all WebElements are displayed.

        /*

Home link verification Passed!
Forgot password header verification Passed!
E-mail text verification Passed!
E-mail input box verification Passed!
Retrieve password button verification Passed!
Powered by Cybertek School text verification Passed!

         */
    }

}
