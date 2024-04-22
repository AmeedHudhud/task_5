package org.test.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class test {

    @Test
    public void signInByValidUsernameAndPassword(){
        WebDriver driver =new ChromeDriver();
        driver.get("https://talent500.co/auth/signin?redirect_to=jobs");
        driver.findElement(By.cssSelector("[placeholder=\"Email\"]")).sendKeys("hudhudameed@gmail.com");
        driver.findElement(By.cssSelector("[placeholder=\"Password\"]")).sendKeys("ameed0595");
        driver.findElement(By.cssSelector("[data-id=\"submit-login-btn\"]")).click();
    }

}
