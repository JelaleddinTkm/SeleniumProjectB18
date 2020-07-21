package test.day11_page_object_model;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;


public class c_PositiveLoginTests {

    LoginPage loginPage;

    @Test
    public void tc32_store_manager_login_test() {

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        loginPage =new LoginPage();

        String username = ConfigurationReader.getProperty("storemanager_username");
        String password = ConfigurationReader.getProperty("storemanager_password");

        loginPage.login(username, password);

        //title verification
        String expectedTitle = "Dashboard";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);






    }
}
