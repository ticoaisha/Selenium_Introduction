import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aishe\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        /* when you will do this step, Selenium will pause until this page is fully loaded
        * wait until all the components of this page will be fully loaded
        * it will wait by default */
        driver.get("http://google.com");

        /* here it will not wait
        * once the page is loaded, it will continue
        * with navigate you will have synchronization issues
        * and you will need to handle those with implicitWait, explicitWait or Thread.sleep
        * so navigate() is helpful when you are already in the automation mode
        *
        * */
        driver.navigate().to("http://rahulshettyacademy.com");
        driver.navigate().back();
        driver.navigate().forward();

    }
}
