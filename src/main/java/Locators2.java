import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {

        String name = "rahul";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aishe\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello " + name +",");

        /*
        * we can't use linkText here because it is not an anchor element (it is button element)
        * //button[text()='Log Out']
        * or also we can put * instead of button if we do not want to specify tag
        * for example when the text is unique
        * //*[text()='Log Out']
        *
        * also no option to use text for CSS selector
        * */

        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        /*
         * Please use temporary password 'rahulshettyacademy' to Login.
         * when we will split this String, we will get an Array with 2 elements:
         * 0th index - Please use temporary password
         * 1st index - rahulshettyacademy' to Login.
         */

        String[] passwordArray = passwordText.split("'");
//        String[] passwordArray2 = passwordArray[1].split("'");
//        passwordArray2[0]
//        instead of these 2 lines we can write the below
        String password = passwordArray[1].split("'")[0];
        return password;
    }
}
