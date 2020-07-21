package test.day07_javafaker_webtables;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerPractice {

    @Test
    public void faker_test() {

        Faker faker = new Faker();

        String name = faker.name().fullName();
        System.out.println("name = " + name);

        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);

        String streetAddress = faker.address().streetAddress();
        System.out.println("streetAddress = " + streetAddress);

        String gameOfThrones = faker.gameOfThrones().character();
        System.out.println("gameOfThrones = " + gameOfThrones);



        /*

name = Tyron Bergnaum
firstName = Stephan
lastName = Welch
streetAddress = 69237 Adrienne Valleys
gameOfThrones = Jeffory Norcross


===============================================
Default Suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================


      */



    }
}
