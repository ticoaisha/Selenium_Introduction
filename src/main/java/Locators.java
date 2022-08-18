import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aishe\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        /*
         * implicit wait
         * wait at least XX sec
         * Selenium will keep evaluating every second of the time that I have provided
         * if the element was found within 2 sec and I specified 5 sec - it will not wait until 5 sec
         *
         * by this we are taking care of the synchronization issues
         * we specified it here, so it is globally available for every step
         *
         *
         * */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("sarah");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");

        /*
        * if class name has a space in its name, it means that there are 2 classes
        * for example class="submit signInBtn", two classes here: submit and signInBtn
        * for the locator we can give either one
        * */

        driver.findElement(By.className("signInBtn")).click();
        /*
        * CSS Selector - how to generate:
        * Class name -> tagname.classname
        * id -> tagname#id
        * tagname is optional, I can do .classname or #id, it will still work
        * but we need to make sure that this is only one such class in that page
        *
        * Selenium generally work from left, so once it will find the class
        * it will not work further
        *
        * if the element does not have id or class name:
        * tagname[attribute='value']
        *
        * plugins: ChroPath and SelectorsHub will help to identify
        * if the locators you wrote are unique or not
        *
        * if there is no access to these plugins, then
        * go to developer tool -> Console -> $('CSS selector')
        * */

        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        /*
        * we can use Link Text only when a tag name in the html code
        * */
        driver.findElement(By.linkText("Forgot your password?")).click();
        /*
        * for xpath to find in Console on dev tools:
        * $x('//input[@placeholder="Name"]')
        * Name should be in "" because '' cannot go inside ''
        * */

        /* script will pause for XX ms before continuing
        * we need to do this as we are transitioning from one view to another view
        * so the application will be in the stable stage for the rest of the script to run
        *
        * if we would not do this we would get an Exception:
        * ElementClickInterceptedException: element click intercepted:
        * element is not clickable
        *
        * we could use "explicit wait" here and replace Thread.sleep
        *
        * implicit wait - wait for the objects to show on the page
        * Thread.sleep - wait until object will go to the stable stage
        * */
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
        /*clear() will clear value that we gave */
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
        /* xpath with the help of tags */
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("7067834567");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
        /*
        * input[type*='pass'] - CSS Selector with the use of * -> regular expression
        * so Selenium will scan all the elements with the "type" attribute and word "pass" in the value
        *
        * we can use the above when for example an element is dynamic and
        * part "word" of the word "password" is disappearing
        * and we are trying to find an element only
        *
        * */
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        /*
        * if class="XXX XXXX" has two names in its value, it means that those are 2 different classes
        * if you will go with By.className, you can use one of class
        * if you will do customized xpath pr CSS selector, you need to specify the full class name
        *
        * //button[@class='submit signInBtn']
        * instead of the above we can do below, when for example when the element is dynamic
        * //button[contains(@class,'submit')]
        * */
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
    }
}
