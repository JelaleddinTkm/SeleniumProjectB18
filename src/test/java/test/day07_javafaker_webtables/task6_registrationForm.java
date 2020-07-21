package test.day07_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class task6_registrationForm {

    WebDriver driver;

    //TC#6:
    // Cybertek registration form confirmation
    // Note: Use JavaFaker when possible.

    @BeforeMethod
    public void setUp() {

        // 1.Open browser
        // 2.Go to website: http://practice.cybertekschool.com/registration_form

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/registration_form");

    }


    @Test
    public void registrationForm() {

        Faker faker = new Faker();

        // 3.Enter first name
       WebElement inputFirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
       inputFirstName.sendKeys(faker.name().firstName());

        // 4.Enter last name
       WebElement inputLastName = driver.findElement(By.xpath("//input[@name='lastname']"));
       inputLastName.sendKeys(faker.name().lastName().replaceAll("'",""));

        // 5.Enter username
       WebElement inputUsername = driver.findElement(By.xpath("//input[@name='username']"));
       inputUsername.sendKeys("anyway");

        // 6.Enter email address
       WebElement inputEmail = driver.findElement(By.xpath("//input[@name='email']"));
       inputEmail.sendKeys(faker.internet().emailAddress());

        // 7.Enter password
       WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
       inputPassword.sendKeys(faker.internet().password());

        // 8.Enter phone number
       WebElement inputPhone = driver.findElement(By.xpath("//input[@name='phone']"));
       inputPhone.sendKeys("425-123-4567");

        // 9.Select a gender from radio buttons
       WebElement genderButton = driver.findElement(By.xpath("//input[@name='gender']"));
       genderButton.click();

        // 10.Enter date of birth
        WebElement inputDateOfBirth = driver.findElement(By.xpath("//input[@name='birthday']"));
        inputDateOfBirth.sendKeys("05/25/2000");

        // 11.Select Department/Office
        Select department = new Select(driver.findElement(By.name("department")));
        department.selectByVisibleText("Accounting Office");

        // 12.Select Job Title
        Select jobTitle = new Select(driver.findElement(By.name("job_title")));
        jobTitle.selectByIndex(3);

        // 13.Select programming language from checkboxes
        WebElement selectLanguage = driver.findElement(By.xpath("//div[@class='form-check form-check-inline']"));
        selectLanguage.click();

        // 14.Clickto sign up button
        WebElement signUpButton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        signUpButton.click();

        // 15.Verify success message “You’ve successfully completed registration.”is displayed.
        WebElement successMessage = driver.findElement(By.xpath("//h4[@class='alert-heading']/following-sibling::p"));
        Assert.assertTrue(successMessage.isDisplayed());



    }
}
