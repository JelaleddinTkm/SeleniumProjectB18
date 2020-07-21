package test.day03_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.WebDriverFactory;

public class ExampleForWebDriverFactory {

    public static void main(String[] args) {

        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.google.com");

    }
}
