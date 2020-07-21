package test.day13_FULL_REVIEW;

public class Class_Notes {

    /*

JULY 9, THURSDAY

TODAY WILL BE FULL REVIEW SESSION

--> WHAT IS SELENIUM?
    --> Selenium is a collection of jar files that allows us to  automate browsers

--> WHY WE ARE USING SELENIUM? What are the advantages of Selenium?
    -> OPEN SOURCE --> It is FREE
    -> It supports multiple programming languages
    -> It supports multiple BROWSERS
    -> It supports multiple OS: MAC, Windows, Linux, ...
    -> There is a huge community behind it supporting, and advancing selenium libraries.

--> What is a web element?
   -> Everything we see on the web page such as images, buttons, links, iniputs etc.

--> GETTEXT VS GETATTRIBUTE VALUE METHODS
    -> What are the return types? And similarities, differences?
        -> First we need to say what they actually do.

        - getText():
            - getText ==> get the text of the webElement that is in between the OPENING TAG AND CLOSING TAG
            - getText does not accept any argument
            - Return type is String

        Ex:
            <a href="https://google.com"? LINK TEXT </A>

            --> getText would return : LINK TEXT

        - getAttribute("attribute"):
            - getAttribute returns the value of given attribute as a String
            - Accept a String as an argument

        Ex:
          <a href="https://google.com" class="hm45"> LINK TEXT </A>

          webElement. getAttribute("href") --> https://google.com
          webElement. getAttribute("class") --> hm45


--> WHAT ARE LOCATORS? AND HOW MANY LOCATORS IN SELENIUM?
        -> Locators ARE methods to locate a web element and we have 8 locators
        -> id, name, classname, tagName, linkText, partialLinkText, cssSelector, xpath

--> WHY DO WE HAVE 8 LOCATORS?
        -> The reason we have 8 locators is because to have flexibility.
        -> where one doesn't work, the other one will work.

--> How many types of XPATH are there?
        -> 2 types of xpath

      1- Absolute xpath :
            - Starts from the root web element: HTML and goes down 1 by 1 from parent ot child
            - Starts with / (single slash)

            Ex: html/body/div/div/img

            - Why should we avoid using absolute xpath?
            - Not reliable, bec it will easyly break with any changes in HTML structure change.
            -

      2- Relative xpath :
            - Starts with // (double slash)
            - It allows us to start anywhere in the html code,
            - it is more reliable bec we are starting from either the webElement itself
            - OR one of the static parents or children
            - when we say // it will jump to the given web element

              ex:
              //div --> this will jump to the first div it finds
              //div[@attribute='value'] --> more specific relative xpath
              //button[.='text'] --> locates the web element with the given text

            - instead of giving tagName, if you pass *, it will only check for attributes and values
            - whenever you are have hard time locating with xpath, always try to find a static (stable/non changing) parent or child t the desired web element we aer trying to locate and go from there.

  ====================================================================================

  --> WHAT IS MAVEN?
        -> BUILT AUTOMATION TOOL
        -> MAVEN HELPS US CREATE AND MANAGE PROJECTS EASYLY

 --> WHAT IS BUILT?
        -> Creating, adding, compiling, testing, AND deploying a project: all of these steps are called A BUILT
        -> Since maven is BUILT AUTOMATION TOOL it helps us automate all of these steps.

--> Similar tools to maven : Gradle, Ant, and many others.

--> We can run maven in terminal as well. We need to install the maven into our computers
    -> The maven that comes inside of IntelliJ is limited inside of IntelliJ.

--> What is pom.xml and what do we do with this file?
    -> pom.xml stands for PROJECT OBJECT MODEL
    -> It is an .xml type of file
    -> xml stand for Extensible Markup Language
    -> We manage all the dependencies in our project from pom.xml
    -> It also helps us to manage version of our dependencies

--> When you create a maven project, maven automatically creates a folder called :
    -> .m2
    -> hidden folder

--> Differences between findElement and findElements:
    -> findElement:
        -> Return type is WebElement
        -> if it does not find anything with the given locator, it will throw NoSuchElementException

    -> findElements:
        -> Return type is List<WebElement> : list of web elements
        -> it does not throw exception if web element is not found
        -> it will simply return an empty List.

--> Checkboxes adn radio buttons:
    - How we handle?
        - We just locate as any other web element and we use click(); method to click them.
        - isSelected() method verifies if checkboxes or radio buttons are selected or not
        - return type of isSelected():
            - boolean
            - if given checkbox/radiobutton selected, it will return true, if not false.
        - isEnabled() method:
            -> This method just checks if the checkbox is clickable or not.
            -> If it is enabled, it will return .....


TestNG --> TEST NEXT GENERATION
        - WHAT IS TESTNG?
            - TestNG is a unit testing tool
            - TestNG allows us to create test structure using tis annotations

        - To add TestNG we need to add libraries of it. If we are using maven, all we need to do is to add the dependency into our project.


---> What are some of the annotations in TestNG?
        - There are around 15 annotations in TestNG.

        @Test : makes the annotated method a TestNG test.
                - so, that we can do assertions in that test method.




--> DROPDOWNS

    HOW MANY TYPES OF DROPDOWNS DO WE HAVE?
    - 2 types of dropdowns

    1- HTML dropdown
    2- Select dropdown

    1- How do we know if it is select or html dropdown?
        - we inspect. If we see <select> tag, it is select dropdown

    2- How do we handle Select dropdowns?
        - we need to create and object of the Select dropdown.

        Select dropdown = new Select(WebElement);
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));


How many ways there are to select from a dropdown?
    -> we have 3 ways to select from dropdowns.

    1- SelectByVisibleText --> select.selectByVisibleText(“option1”);
        -->this method accept a String argument and select the option with thw given text.
    2- by Index --> This method accepts an int argument as the index number of the option.
        --> Indexes start from 0.
    3- By value --> this method uses the value of the attribute “value” to select options





    ==========================================================

ALERTS:

    HOW MANY TYPES OF ALERTS ARE THERE?
        - TWO TYPES OF ALERTS

   1- HTML ALERTS :  We just locate it as another web element. Then click to handle.

   2- JavaScript Alerts:  We cannot locate this from the html using regular selenium locators.

        How do we handle JS Alerts?
            - We handle alerts using Alerts.
            - Alerts coming from selenium.

            - We need to switch to the alert using Alert instance.

            syntax: Alert alert = driver.switchTo().alert();

       How many types of JS Alerts?
            - 3 types of JS Alerts.

            1- Warning/Information : we have option to accept or dismiss.
            2- Confirmation        : We have the option to accept or dismiss.
            3- Prompt              : We can accept, dismiss AND sendKeys as additional information.

            alert.accept();
            alert.dismiss();
            alert.sendKeys();


====================================================================================

    IFRAME : INLINE FRAME

    -> HTML INSIDE OF ANOTHER HTML
    -> WHY DO WE HAVE TO SWITCH TO ANOTHER IFRAME?
        - Because selenium can only focus one thing at a time.
        - To be able to do any acton inside of the inner frame we need to switch to it.

        syntax : driver.switchTo().frame();

        We have 3 ways to switch to iframe:

        1- INDEX: We pass the index number of the frame we want to switch
            driver.switchTo().frame(0);

        2- ID or NAME ATTRIBUTE VALUE:
            driver.switchTo().frame("idValue");
            driver.switchTo().frame("nameValue");

       3- Locating the <iframe> web element with any of the locators and passing it into .iframe() method
            driver.switchTo().frame(WebElement);



====================================================================================================


WINDOWS/TABS:
        - windowHandle/windowHandles
        - We have to change selenium's focus to the window/tab we want to work on.

        How do we do that?
            -> Using windowHandles.


        A windowHandle : is randomly generated string that is unique to each window.

        syntax to get window handle:
             driver.getWindowHandle();

        What is the return type:
            - Return a String which is the handle of current window

        How to get all of the window handles?
            - driver.getWindowHandles();
            - Return type:
                -> Set of Strings : set does not allow to store any duplicate values.
                -> Everything must be unique inside the set.

            syntax to switch to window:
                driver.switchTo().window(windowHandle);


=============================================================================================


PROPERTIES :
        - What kind of data (what format) does the properties file store?
            -> KEY and VALUE format
            -> We want to avoid hard coding some of the important test data.
            -> For this reason, we use properties file to pass some important test data that can change the flow of running of our test.

       - configuration.properties :
            -> browser : by changing one value of a key, we run on different browser
            -> url
            -> username, password

      - What is cross browser testing?
            -> Running the same tests on different browsers.

      - What is called running the same TESTS on different data sets?
            -> DATA DRIVEN TESTING

      - What is parallel testing?
            -> Running tests on different machines.

      - Why do we do parallel testing?
            -> To save time


=================================================================================================


    - What is Singleton design pattern and how do we achieve it?
            -> the singleton pattern is a software design pattern that restricts the instantiation of a class to one "single" instance.
            -> This is useful when exactly one object is needed to coordinate actions across the system. The term comes from the mathematical concept of a singleton.
            -> We use the Singleton design pattern in our Driver Utility
            -> We can decide which web driver instance will be used

    - How do we achieve?
            -> We create a private constructor. And create a getter method to return the same object.


==================================================================================================


ACTIONS :
     What does Actions class allow us to do?
           -> Allows us to handle advanced mouse and keyboard actions.
           -> Such as:
                - hover over
                - drag and drop
                - double click
                - right click

     How do we use Actions?

        syntax : Actions action = new Actions(Driver.getDriver());

        action.methodName.perform();
        action.moveToElement(webElement).perform();
        action.doubleClick(webElement).perform();

























     */
}
