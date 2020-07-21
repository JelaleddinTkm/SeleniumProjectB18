package test.day09_testbase_properties_driverUtil;

public class Singleton {

    /*

    SINGLETON DESIGN PATTERN:
-> Making the constructor private to limit the user access to the object of the class.
-> Then we create our own logic with our getter method, to allow user to use the instance we are creating.

     */


    private Singleton() {

    }

    private static String word;


    public static String getWord() {

        if(word == null) {
            System.out.println("First call. Word object is null." +
                    "Assigning value to word right now.");
            word = "somthing";

        }else {
            System.out.println("Word has already has value");
        }

        return word;
    }
}
