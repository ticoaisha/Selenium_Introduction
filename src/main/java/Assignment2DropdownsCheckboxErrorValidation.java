import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2DropdownsCheckboxErrorValidation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aishe\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("Aishe");
        driver.findElement(By.name("email")).sendKeys("someemail@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("abc123#45");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));
        Select genderOption = new Select(gender);
        genderOption.selectByVisibleText("Female");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("09/17/1983");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        System.out.println(driver.findElement(By.className("alert-success")).getText());
    }
}
