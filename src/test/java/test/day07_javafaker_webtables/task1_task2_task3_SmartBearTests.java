package test.day07_javafaker_webtables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class task1_task2_task3_SmartBearTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //TC #1:
        // Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //3. Enter username: "Tester"
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        inputUsername.sendKeys("Tester");

        //4. Enter password: "test"
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");

        //5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
    }


    @Test
    public void p1_smartbear_login_test() {

        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        int expectedNumberOfLinks = 6;
        int actualNumberOfLinks = allLinks.size();

        Assert.assertEquals(6,actualNumberOfLinks);

        //7. Print out each link text on this page
        for (WebElement link : allLinks){
            System.out.println(link.getText());
        }


        /*

View all orders
View all products
Order
Logout
Check All
Uncheck All


===============================================
Default Suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================

         */


    }


    @Test
    public void p2_smartbear_order_placing() throws InterruptedException {

    //TC#2:
    // Smartbear software order placing
    //1. Open browser
    //2. Go to website:
    //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3. Enter username: "Tester"
    //4. Enter password: "test"
    //5. Click on Login button

    //    UNTILL HERE ALL DONE ABOVE...


    //6. Click on Order
    WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
    orderLink.click();

    //7. Select familyAlbum from product, set quantity to 2
    Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
    productDropdown.selectByVisibleText("FamilyAlbum");

    WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

    //quantityInput.clear(); //just deletes if there is any existing input in the input box.
    Thread.sleep(1000);
    //Imitating as if the user is pressing the BACKSPACE key on keyboard to delete something.
    quantityInput.sendKeys(Keys.BACK_SPACE);

    Thread.sleep(1000);
    quantityInput.sendKeys("2");

    //8. Click to “Calculate” button
    WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
    calculateButton.click();

    //9. Fill address Info with JavaFaker
    WebElement inputCustomerName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
    WebElement inputStreet = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
    WebElement inputCity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
    WebElement inputState = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
    WebElement inputZip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

    Faker faker = new Faker();

    //• Generate: name, street, city, state, zip code
    // Entering name using javafaker.
    inputCustomerName.sendKeys(faker.name().fullName());

    //Entering street using javafaker
    inputStreet.sendKeys(faker.address().streetName());

    //Entering city using javafaker
    inputCity.sendKeys(faker.address().city());

    //Entering state using javafaker
    inputState.sendKeys(faker.address().state());

    //Entering zipcode using javafaker
    String zipcode = faker.address().zipCode().replaceAll("-","");
    inputZip.sendKeys(zipcode);

    //10. Click on “visa” radio button
    WebElement visaRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
    visaRadioButton.click();

    //11. Generate card number using JavaFaker
    WebElement inputCardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));

    //Entering credit card number using faker
    inputCardNumber.sendKeys(faker.finance().creditCard().replaceAll("-",""));

    //Entering date
    WebElement expirationDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
    expirationDate.sendKeys("12/25");

    //12. Click on “Process”
    WebElement processButton = driver.findElement(By.xpath("//a[.='Process']"));
    processButton.click();


    //13.Verify success message “New order has been successfully added.”
    //strong
    WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));

    Assert.assertTrue(successMessage.isDisplayed());


    /*

===============================================
Default Suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================

     */


     }



     @Test
   public void p3_smartbear_order_verification() {
        //TC#3:
       // Smartbear software order verification
       // 1.Open browser and login to Smartbear software
       // 2.Click on View all orders
       // 3.Verify Susan McLaren has order on date “01/05/2010”
         WebElement susansDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));

         String expectedDate = "01/05/2010";
         String actualDate = susansDate.getText();

         Assert.assertEquals(actualDate, expectedDate);





     }




}


