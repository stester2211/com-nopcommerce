package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowser
{
    public static Scanner sc=new Scanner(System.in);
    static String baseURL="https://demo.nopcommerce.com/login?returnUrl=%2F";

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException
    {
        System.out.print("Enter the browser name: ");
        String browser=sc.nextLine();

        //1. Setup Multibrowser

        if(browser.equalsIgnoreCase("Chrome"))
        {
            driver=new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("Edge"))
        {
            driver=new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("Firefox"))
        {
            driver=new FirefoxDriver();
        }
        else
        {
            System.out.println("Enter only Chrome, Edge or Firefox for testing");
        }

        // Maximize Browser
        driver.manage().window().maximize();

        // Implicite wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2. Open URL
        driver.get(baseURL);

        //3. Print the title of the page
        System.out.println("----------------------------------------");
        System.out.println("3. Page title is : " + driver.getTitle());

        //4. Print the current URL
        System.out.println("4. Current URL is : "+driver.getCurrentUrl());

        //5. Print page source
        System.out.println("5. Page source is : "+ driver.getPageSource());

        //6. Enter the email to email field
        //6.1 Find email element
        WebElement emailField= driver.findElement(By.name("Email"));

        //6.2 Action is Enter the text
        emailField.sendKeys("V123@gmail.com");

        //7. Enter the password to password field
        //7.1 Find password element
        WebElement passwordField= driver.findElement(By.name("Password"));

        //7.2 Action is Enter the text
        passwordField.sendKeys("V12345");

        // Holding screen for sometime
        Thread.sleep(2000);

        //8. Close the browser
        driver.close();
    }
}
