import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {
    public static void main(String[] args) throws InterruptedException {

        /* Need to work on this */
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aishe\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.orbitz.com/");
        driver.findElement(By.xpath("(//div[@class='uitk-date-picker-menu uitk-menu uitk-menu-mounted'])[1]")).click();
Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class='uitk-date-picker-day edge']")).click();

//        Assert.assertTrue(driver.findElement(By.cssSelector("button[xpath='1']")).isSelected());
    }
}
