package test.OfficeHour_day02_Creating_utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReaderPractice {


    WebDriver driver;

    private static Properties properties;


    static {

        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
             properties = new Properties();
             properties.load(fileInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static String getProperty(String key) {
        return properties.getProperty(key);
    }




    public static void main(String[] args)  {

        String browser = properties.getProperty("browser");
        System.out.println(browser);

        //we will get null, if there is no such a property
        System.out.println(properties.getProperty("url"));


    }



    //---------------------------------------------------------------------------------



    @Test
    public void loginTest() throws InterruptedException {

        String browser = getProperty("browser");  //here we didn't call config.properties bec it is in a same class, we use it when use this in an other class
        String URL = getProperty("url");
        String username = getProperty("username");
        String password = getProperty("password");

        driver = WebDriverFactory.getDriver(browser);

        driver.get(URL);
        System.out.println("Page title: " + driver.getTitle() );

        //login
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);

        Thread.sleep(5000);

        String expected = "Dashboard ";
        String actual = driver.getTitle();

        Assert.assertEquals(actual, expected, "Page title is not correct!");


    }



    @AfterMethod
    public void tearDown() {
        driver.close();
    }



    /*
    - to go into the method/class implementation click and hold control(win)/command(mac) and make a click
     */



}
