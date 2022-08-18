import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1Checkboxes {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aishe\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input[value='option1']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());
        driver.findElement(By.cssSelector("input[value='option1']")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
    }
}
