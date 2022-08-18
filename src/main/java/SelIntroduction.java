import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

    public static void main(String[] args) {

       /* Invoking Browser
      Chrome - ChromeDriver is a class -> Methods
        We need to create the object of the class to access the methods present in the class
        Interface is a group of related methods with empty bodies

                ChromeDriver driver = new ChromeDriver();
                driver object here has access to all the methods of Chrome driver
                WebDriver is an interface

                WebDriver driver = new ChromeDriver();
                driver object here has access to the methods of Chrome driver which
                are defined in the WebDriver Interface

        It is class responsibility to implement the methods declared in the interface
        When class agreed to implement the interface,
        they must need to provide implementation/bodies
        to all the defined methods in the Interface

        In simple terms, Interface enforces the Contract to class to follow

        WebDriver methods + class methods

        Selenium cannot directly access the browser
        Selenium invokes chromedriver.exe file. This file will invoke Chrome browser
        chromedriver.exe is a third party file, provided by the Chrome, has nothing with Se
        It is like a heart. Our goal is to invoke this file
        Se internally will look for this key value: webdriver.chrome.driver
        in this key value we need to give the value of the path where this file is present in your local
        */
//        This method will set property on a glodal level
//        .exe is required on Windows, not on Mac
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aishe\\chromedriver_win32\\chromedriver.exe");
        /*
        *We are setting this property with this value
        * on run time Se checks this property, find this path, go to that path and invokes chromedriver
        * That driver will take all the code, invoke Chrome browser and
        * perform all the actions on Chrome browser
        * */


        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        /*
        * driver.close() will close only the window which was originally opened
        * driver.quit() will close all the associated windows which got opened by automation,
        *
        * driver.close() closes the surrent windows
        * driver.quit() closes the driver
        *
        * if my script will have multiple windows to be opened, I will choose driver.quit()
        * but we cannot to use both
        *
        * */
        driver.close();
//        driver.quit();
    }
}
