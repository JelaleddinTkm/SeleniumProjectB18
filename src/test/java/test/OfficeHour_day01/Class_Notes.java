package test.OfficeHour_day01;

public class Class_Notes {

    /*

    /*

    Selenium Office

    1. WebElement
    2. getText(), getAttribute()
    3. Locators
    4. checkboxes, radio buttons
    5. testng
    6. dropdown
    7. webtables
##############################
    API - libraries with classes and methods that we use to talk to another program
    Selenium WebDriver API (Application Programing Interface) - used to automate web browser
    We use Selenium WebDriver to develop test automation scripts for web based applications
    web based application - the one that you see in the browser, once you enter some URL.
    Where is your selenium? It's a maven dependency:
         <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
    Maven will download library and add it to your project.
Everything starts from webdriver object:
 WebDriver driver = new ChromeDriver() ---> will work with Chrome browser
 WebDriver driver = new FirefoxDriver() ---> will work with Firefox browser
 WebDriver driver = new SafariDriver() ---> will work with Safari browser
driver - it's a webdriver object. Via this object, we send commands to the browser.
WebDriver - it's an interface, that is implemented by RemoteWebDriver class ---> RemoteWebDriver parent class for:
    - ChromeDriver
    - EdgeDriver
    - SafariDriver
    - FirefoxDriver
We created webdriver object. Is it enough?
- no, we need to add browser driver! Browser driver - middleman, between your code and Browser.
WebDriverManager.chromedriver().setup();
To setup manually:
1. Go to google, find driver for your browser. For instance: google chrome - chromedriver, firefox - geckodriver.
    https://chromedriver.chromium.org/
for mac: chromedriver
for windows: chromedriver.exe
To setup before object instantiation:
    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver");
Why do you need to know this?
- because not every company webdriver is allowed to use.
- also, it has issues with old OS versions, sometimes it cannot pull webdriver from the Internet.
    driver.get("http://google.com") - to open some page. This is a very first method to use in every test
If we opened browser, then we need to close it at the end:
    driver.close() - to close current tab/window. If it's the only one windows, it will also shutdown browser.
    driver.quit()  - to close all opened by webdriver windows, make session null.
driver.navigate().back() -- to navigate to previous website in the history
driver.navigate().forward() -- to navigate to forward website in the history. can be called after back()
driver.navigate().refresh() -- reload current window
driver.navigate().to() -- same as driver.get()
every window has a title, to read it use getTitle()
page title can help you to jump in between windows
WebElement - interface, that is used to wrap some HTML element and represent it as java object.
<input type="text" id="field">
WebElement element        = driver.findElement(By.id("field"))
List<WebElement> elements = driver.findElements(By.tagName("a"));
list ---> [element1, element2, ....]
elements.get(0)----> element1
findElement != findElements
How do we find elements? Based on locator.
we have 8 locators: id, name, tagName, className, cssSelector, xpath, linkText, partialLinkText
The best way to allocate element - id, since it's always unique.
- if id tend to change, use cssSelector or xpath.
<input type="text" id="field">            By.id("field")
<input type="text" name="field">          By.name("field")
<input type="text" class="field">         By.className("field")
<input type="text">                         By.tagName("input")
<a href="http://google.com">Google page</a> By.linkText("Google page")
<a href="http://google.com">Google page</a> By.partialLinkText("Google")
linkText/partialLinkText work only with elements that have tag name <a>
a - hyperlink, and visible text of hyperlink can be used to find that element. Visible text always located in between opening and closing tags: <a>TEXT</a>
XPath - XML path, that was originally created for XML documents. XML and HTML documents have similar structure, and that's why we can use XPath in HTML documents as well.
there are 2 types of xpath: absolute and relative
absolute xpath:
    - start with a root element
    - you cannot skip any level, you must go from parent to child element.
    /html/body/div/div[2]/input
not commonly used in test automation.
relative xpath:
    - it can start from anywhere in the document
    //tagName
    //tagName[@attribute='value']
    //tagName[@attribute='value' and @attribute='value'] - locator with 2 attributes
    //tagName[@attribute='value' or @attribute='value']  - locator with either or attributes
instead of tagName, you can specify * - to match any tag name
what makes xpath special from other locators, is that you can find element based on text:
    //tagName[text()='Some text'] or //tagName[.='Some text']
another advantage is that you can go to parent element:

    /..
For example:
    //*[text()='Sign in securely']/..
you can find element by partial text/attribute value:
    //*[contains(text(),'Some text')]
    //*[contains(text(),'Sign in secu')]
    //*[contains(@attibute,'Value')]
How to handle dynamic element?
    by using xpath, find stable parent element and based on that point "dynamic" child
    use xpath with contains
dynamic element - web element that has inconsistent attributes.
Also, you can use siblings to find elements:
<div class="box-small">
    <label>First name</label>
    <input type="text" name="first_name">
</div>
label and input elements are siblings. div element - is their parent.
//label[text()='Black']/preceding-sibling::input
/\
|| preceding
|| following
\/
//input[@id='black']/following-sibling::label
css selector (don't forget that there is no / or //)
tagName[attribute='value']
# - means ID
. - class name
> direct child
* you cannot find element based text
tagName[attribute*='partial value'] - like contains() in xpath
^ - caret sign
~ - tilde
| - pipe
tagName[attribute^='val'] - like in xpath starts-with()



     */

}
