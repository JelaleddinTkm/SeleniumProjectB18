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

public class ownPractice {

    //TC #1:
    // Smartbear software link verification
    WebDriver driver;

   @BeforeMethod
    public void setUp() {

       // 1.Open browser
       // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
       driver = WebDriverFactory.getDriver("chrome");
       driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       // 3.Enter username: “Tester”
       WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
       inputUsername.sendKeys("Tester");

       // 4.Enter password: “test”
       WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
       inputPassword.sendKeys("test");

       // 5.Click to Login button
       WebElement clickToLoginButton = driver.findElement(By.xpath ("//input[@id='ctl00_MainContent_login_button']"));
       clickToLoginButton.click();
   }


/*
   @Test
    public void login_test() {

       // 6.Print out count of all the links on landing page
       List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

       int actualNumberOfLinks = 6;
       int expectedNumberOfLinks = allLinks.size();

       // 7.Print out each link text on this page
       for(WebElement each : allLinks) {
           System.out.println(each.getText());
       }





   }




   //TC#2:
    // Smartbearsoftware order placing
    // 1.Open browser
    // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    // 3.Enter username: “Tester”
    // 4.Enter password: “test”
    // 5.Click on Login button
    //---------------------------UNTIL HERE DONE ABOVE----------------------------------

    @Test
    public void p2_order_placing_test() {

       // 6.Click on Order
       WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
       orderLink.click();

        // 7.Select familyAlbum from product, set quantity to 2
        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityInput.sendKeys(Keys.BACK_SPACE);
        quantityInput.sendKeys("2");

        // 8.Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        // 9.Fill address Info with JavaFaker •Generate: name, street, city, state, zip code
        WebElement inputCustomerName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement inputStreet = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement inputCity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement inputState = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement inputZip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        Faker faker = new Faker();

        //Generate: name, street, city, state, zip code
        inputCustomerName.sendKeys(faker.name().fullName());
        inputStreet.sendKeys(faker.address().streetAddress());
        inputCity.sendKeys(faker.address().city());
        inputState.sendKeys(faker.address().state());
        inputZip.sendKeys( faker.address().zipCode().replaceAll("-","") );


        // 10.Click on “visa” radio button
        WebElement visaRadioButton = driver.findElement(By.xpath("//input[@id='id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaRadioButton.click();

        // 11.Generate card number using JavaFaker
        WebElement inputCardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        inputCardNumber.sendKeys(faker.finance().creditCard().replaceAll("_",""));

        // 12.Click on “Process”
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();

        // Entering date
        WebElement expirationDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expirationDate.sendKeys("12/25");

        // 13.Verify success message “New order has been successfully added.”
        WebElement successMessge = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
    }

 */


    @Test
    public void locatingElementsInTable(){

//        //Locating whole table
//        WebElement locatingWholeTable = driver.findElement(By.xpath("//table[@class='SampleTable']"));
//
//        //Locating all the rows in the table
//        WebElement locatingAllRows = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr"));
//
//        //Locating all of the cells in all of the rows
//        WebElement locatingAllCells = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr/td"));
//
//        //Locating Paul Brown from the table with text
//        WebElement locatingPaulBrown = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr/td[.='Paul Brown']"));
//
//        //Locating Paul Brown from the table using index numbers
//        WebElement locatingPaulBrown2 = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[3]/td[2]"));
//
//        //Locate Las Vegas from the table using any text
//        WebElement locatingLasVegas = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[3]/td[7]"));
//
//        //Locating Steve Johns from the table using index numbers
//        WebElement locatingSteveJohns = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[5]/td[2]"));
//
//        //Locating Steve Johns from the table using the text
//        WebElement locatingSteveJohns2 = driver.findElement(By.xpath("//td[.='Steve Johns']"));
//
//        //Locating Steve Johns's order date from the table
//        WebElement locatingSteveJohnsOrderDate   = driver.findElement(By.xpath("//td[.='Steve Johns']/../td[5]"));
//        WebElement locatingWSteveJohnsOrderDate2 = driver.findElement(By.xpath("//td[.='Steve Johns']/following-sibling::td[3]"));
//
//        //Locating Clare Jefferson's city
//        WebElement locatingClareJeffersonCity = driver.findElement(By.xpath("//td[.='Clare Jefferson']/following-sibling::td[5]"));
//
//        //Locate Steve Johns's check box
//        WebElement locatingSteveJohnsCheckBox  = driver.findElement(By.xpath("//td[.='Steve Johns']/preceding-sebling::td"));  // td=td[1]
//        WebElement locatingSteveJohnsCheckBox2 = driver.findElement(By.xpath("//td[.='Steve Johns']/../td[1]"));

        //Verify Susan McLaren has order on date “01/05/2010”
        WebElement SusanMcLarenOrderDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));

        String expectedDate = "01/05/2010";
        String actualDate = SusanMcLarenOrderDate.getText();

        Assert.assertEquals(expectedDate,actualDate);



    }





}
