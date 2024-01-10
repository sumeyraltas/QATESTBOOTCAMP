package org.example.Base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;


public class BaseTest {
   public static WebDriver driver;
    public static String browser = "Firefox";
    //before
    @BeforeClass
    public static void beforeTest(){
        if (browser.equals("Edge")) {
            driver = new EdgeDriver();
        }
        else if (browser.equals("Firefox")){
            driver = new FirefoxDriver();
        } else{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.get("https://www.kostebek.com.tr/login.aspx");
    }
}
