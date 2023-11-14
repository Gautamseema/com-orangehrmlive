package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MultiBrowserTesting {
    public static void main(String[] args) {
        String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

        // Launch the Chrome browser
        WebDriver driver = new ChromeDriver();
        //Open the Url into browser
        driver.get(baseUrl);
        // Maximise the browser
        driver.manage().window().maximize();
        // We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Get the title
        String title = driver.getTitle();
        System.out.println(title);
        // Get current Url
        System.out.println("The current Url : " + driver.getCurrentUrl());
        // Get the page source
        String p = driver.getPageSource();
        System.out.println("Page Source is : " + p);
        //Click on ‘Forgot your password?’ link.
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotPasswordLink.click();
        //Print the current Url
        System.out.println("Current Url after clicking Forgot Password : " + driver.getCurrentUrl());
//
        // Navigate back to homepage
        driver.navigate().back();
        System.out.println("get current Url " + driver.getCurrentUrl());
        // Refresh the page
        driver.navigate().refresh();
        System.out.println("get current Url " + driver.getCurrentUrl());

        // Find username field element and type the email
        WebElement UsernameField = driver.findElement(By.name("username"));
        UsernameField.sendKeys("Admin");
        // Find the password field element and type the email
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        // click loginButton
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        //Close the browser
        driver.quit();
    }
}
