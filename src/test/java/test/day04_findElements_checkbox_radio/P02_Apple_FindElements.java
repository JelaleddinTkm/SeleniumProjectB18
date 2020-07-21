package test.day04_findElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P02_Apple_FindElements {

    public static void main(String[] args) {



        //TC #02: FINDELEMENTS_APPLE
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        // 2.Go to https://www.apple.com
        driver.get("https://www.apple.com");

        // 3.Click to iPhone
        WebElement iphoneLink = driver.findElement(By.xpath("//span[.='iPhone']/.."));

        iphoneLink.click();

        //driver.findElement(By.cssSelector(".ac-gn-link-iphone")).click();
        //driver.findElement(By.xpath("//a[.='iPhone'")).click();
        //driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone'")).click();
        //driver.findElement(By.xpath("//li[@class= 'ac-gn-link ac-gn-link-iphone']")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //4. Print out how many link is missing text
        // we need to locate all of the links on the page
        // ==> //body//a --> well return all of the links INSIDE OF <body>

        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));


        int linksWithoutText = 0;
        int linksWithText = 0;

        for (WebElement eachLink : allLinks) {
            //System.out.println(eachLink.getText());

            String textOfEachLink = eachLink.getText();

            if(textOfEachLink.isEmpty()){
                linksWithoutText++;
            }else{
                System.out.println(textOfEachLink);
                linksWithText++;
            }

        }

        System.out.println("The number of links that does NOT have text: " + linksWithoutText);


        //5. Print out how many link has text
        System.out.println("The number of links that have text: " + linksWithText);


        //6. Print out how many total link
        System.out.println("Total links on this page: " + allLinks.size());


    }
}
