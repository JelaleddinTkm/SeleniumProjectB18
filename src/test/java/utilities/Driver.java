package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Driver {


    //1-Make constructor private
    private Driver() {

    }


    private static WebDriver driver;


    public static WebDriver getDriver() {

        // we use public access modifier, bec we will call it by its name

        if(driver == null) {
            String browser =  ConfigurationReader.getProperty("browser");

            switch (browser) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "firfox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;


                case "chrome-remote":

                    try {
//                        same thing as ChromeOptions
//                        To request Selenium Grid to run tests on Chrome
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
                        desiredCapabilities.setPlatform(Platform.LINUX);
//                        ChromeOptions chromeOptions = new ChromeOptions();
                        URL url = new URL("http://18.206.13.27:4444/wd/hub");
                        driver = new RemoteWebDriver(url, desiredCapabilities);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;



                case "firefox-remote":

                    try {
                        //to request grid to run tests on firefox
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        URL url = new URL("http://18.206.13.27:4444/wd/hub");
                        driver = new RemoteWebDriver(url, firefoxOptions);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;


                default:
                    throw new RuntimeException("Wrong browser name :: "+browser);

            }
        }

        return driver;

    }



    public static void closeDriver() {

        if( driver != null ) {
            driver.quit();
            driver=null;
        }

    }



}
