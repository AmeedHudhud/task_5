package org.test.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class settingHelper extends loginHelper {

//    "//*[text()='Change Password']"
    final String changePasswordLocator = "//*[text()='Change Password']";

    public void changePassword(String OldPassword, String NewPassword, String ConfirmPassword ,WebDriver driver) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(changePasswordLocator)));
        WebElement changePasswordButton = driver.findElement(By.xpath(changePasswordLocator));
        changePasswordButton.click();

        driver.findElement(By.cssSelector("[placeholder='old password']")).sendKeys(OldPassword);
        driver.findElement(By.cssSelector("[placeholder='new password']")).sendKeys(NewPassword);
        driver.findElement(By.cssSelector("[placeholder='confirm password']")).sendKeys(ConfirmPassword);
        driver.findElement(By.xpath("//*[text()='Save']")).click();

        if(Objects.equals(OldPassword, NewPassword)){

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Old and new passwords cannot be the same']")));
        }else if(!Objects.equals(NewPassword, ConfirmPassword)){
//            new WebDriverWait(driver, Duration.ofSeconds(10))
//                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Password Mismatch']")));

            System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        }else if(NewPassword.length()<8){

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Ensure this field has at least 8 characters.']")));
        }

        driver.navigate().refresh();
    }
}
