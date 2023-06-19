package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowser
{
    public static void main(String[] args) throws InterruptedException {
        //1. Setup Chrome Browser
        String baseUrl="https://demo.nopcommerce.com/login?returnUrl=%2F";
        WebDriver driver=new ChromeDriver();

        //2. Opening URL
        driver.get(baseUrl);

        //Maximize browser screen
        driver.manage().window().maximize();

        // Give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Print the title of the page
        System.out.println("-----------------------------------------");
        System.out.println("3. Page title is : " + driver.getTitle());

        //4. Print the current URL
        System.out.println("4. Current URL is :" + driver.getCurrentUrl());

        //5. Print the Page source
        System.out.println("5. Page source is :"+ driver.getPageSource());

        //6. Enter the email to email field
        //6.1 Find the email element
        WebElement emailField =driver.findElement(By.id("Email"));

        //6.2 Action is to enter text
        emailField.sendKeys("vishwa@gmail.com");

        //7. Enter the password to password field
        //7.1 Find the password element
        WebElement passwordField= driver.findElement(By.name("Password"));

        //7.2 Action to enter the password
        passwordField.sendKeys("V123");

        //Just want to hold screen for sometime
        Thread.sleep(2000);

        //8. Close the Browser
        driver.close();

    }
}
