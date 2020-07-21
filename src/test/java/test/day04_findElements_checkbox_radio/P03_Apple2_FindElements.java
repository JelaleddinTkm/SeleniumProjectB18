package test.day04_findElements_checkbox_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class P03_Apple2_FindElements {

    public static void main(String[] args) {

    for (int i = 0; i<7; i++) {
        //TC #03:
        // FINDELEMENTS_APPLE
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2.Go to https://www.apple.com
        driver.get("https://www.apple.com");

        // 3.Click to all of the headers one by one. Mac, iPad, iPhone, Watch, TV, Music, Support

        List<WebElement> headerLinks = Arrays.asList(

                driver.findElement(By.xpath("href=/mac/")),
                driver.findElement(By.xpath("href=/ipad/")),
                driver.findElement(By.xpath("href=/watch/")),
                driver.findElement(By.xpath("href=/tv/")),
                driver.findElement(By.xpath("href=/music/")),
                driver.findElement(By.xpath("href=/https://support.apple.com/")));

        headerLinks.get(i).click();

        // 4.Printout how many links on each page with the titles of the pages
        int totalLinks = 0;
        List<WebElement> pageLinks = driver.findElements(By.xpath("//body//a"));
        totalLinks += pageLinks.size();


        // 5.Loop through all
        int withText = 0;
        int missingText = 0;
        for (WebElement eachLink : pageLinks) {
            if (eachLink.getText().isEmpty()) {
                missingText++;
            } else {
                withText++;
            }
        }

        // 6.Print out how many link is missing textTOTAL
        System.out.println("Links with missing text TOTAL: " + missingText);
        // 7.Print out how many link has textTOTAL
        System.out.println("Links with text TOTAL: " + withText);
        // 8.Print out how many total linkTOTAL
        System.out.println("Links TOTAL: " + totalLinks);


        driver.close();
    }
    }
}
