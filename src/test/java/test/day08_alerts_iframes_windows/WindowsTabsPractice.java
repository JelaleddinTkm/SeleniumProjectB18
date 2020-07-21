package test.day08_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class WindowsTabsPractice {

    WebDriver driver;


    @BeforeMethod
    public void setUp(){

        //TC #
        //Window Handle practice
        //1. Create a new class called: WindowHandlePractice
        //2. Create new test and make set ups
        //3. Go to : http://practice.cybertekschool.com/windows

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/windows");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    @Test
    public void p5_window_handle_practice(){

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("Current window handle: " + currentWindowHandle);
                         // Current window handle: CDwindow-D09BBFA73CDAACD2C9B101C0DF348212

        //4. Assert: Title is “Practice”
        //5. Click to: “Click Here” text
        WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));

        System.out.println("BEFORE CLICKING: " + driver.getTitle());

        clickHereLink.click();

        System.out.println("AFTER CLICKING: " + driver.getTitle());

        //driver.getWindowHandles() --> returns us A SET of String
        for( String each : driver.getWindowHandles() ) {
            driver.switchTo().window( each );
            System.out.println( driver.getTitle() );
        }

        //6. Switch to new Window.
        driver.switchTo().window(currentWindowHandle);
        System.out.println(driver.getTitle());

        //7. Assert: Title is “New Window”

    }


}
