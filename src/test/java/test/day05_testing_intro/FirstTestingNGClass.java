package test.day05_testing_intro;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestingNGClass {


    @BeforeMethod
    public void setUp(){
        System.out.println("Before method running...");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After method running...");
    }

    @Test
    public void test1() {
        System.out.println("Test1 is running...");
    }

    @Test
    public void test2() {
        System.out.println("Test2 is running...");
    }

    /*
Before method running...

Test1 is running...

After method running...

Before method running...

Test2 is running...

After method running...

===============================================
Default Suite
Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
===============================================

     */

}
