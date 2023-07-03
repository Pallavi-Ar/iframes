package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Iframes {
    public static void main(String[] args) throws InterruptedException {
        //giving path to where chrome driver is downloaded
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pallavi.Arora\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //maximizing the window which opens
        driver.manage().window().maximize();
        //deleting all the cookies and cache
        driver.manage().deleteAllCookies();
        //adding pageLoadTimeout of 30secs so that the page is fully loaded before performing any action
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        //opening url
        driver.get("https://demo.automationtesting.in/Frames.html");
        //going to iframe within an iframe
        WebElement Button = driver.findElement(By.linkText("Iframe with in an Iframe"));
        Button.click();
        //switching to iframe 1
        WebElement iframe1 = driver.findElement(By.xpath("//div[@id='Multiple']/iframe"));
        driver.switchTo().frame(iframe1);

        //switching to nested iframe
        WebElement iframe2 = driver.findElement(By.xpath("//div[@class='iframe-container']/iframe"));
        driver.switchTo().frame(iframe2);

        //Passing value in the input box
        WebElement inputbox = driver.findElement(By.xpath("//input[@type='text']"));
        inputbox.sendKeys("Pallavi");

        //clicking on Single Iframe
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Single Iframe")).click();


        //passing name in input field
        driver.switchTo().frame("singleframe");
        WebElement inputbox1 = driver.findElement(By.xpath("//input[@type='text']"));
        inputbox1.sendKeys("Pallavi");
    }
}

