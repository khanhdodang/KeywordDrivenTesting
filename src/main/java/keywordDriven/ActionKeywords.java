package keywordDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.Constants;

public class ActionKeywords {
    public static WebDriver driver;

    public void openBrowser() {

        // System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void navigate() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.URL);
    }

    public void enterUsername() {
        driver.findElement(By.id("username")).sendKeys(Constants.username);
    }

    public void enterPassword() {
        driver.findElement(By.id("password")).sendKeys(Constants.password);
    }

    public void clickLogin() {
        driver.findElement(By.xpath("//button")).click();
    }

    public void logout() {
        driver.findElement(By.xpath("//i[contains(text(),'Logout')]")).click();
    }

    public void closeBrowser() {
        driver.quit();
    }
}
