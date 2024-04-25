package org.test.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DiscoverJobsHelper extends LoginHelper {

    public void clickButton(String locator, WebDriver driver, boolean xpath) throws InterruptedException {

        if(xpath){
//            "//p[text()='Show remote jobs']"
//            Thread.sleep(2000);
            String buttonLocator = "//*[text()='" + locator + "']";
//        driver.findElement(By.xpath(buttonLocator)).click();
//      "//*[text()='View Job' and @data-id='job0-first-CTA']"
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonLocator))).click();
//      driver.findElement(By.xpath("//*[text()='" + Locator + "']")).click();
        }else{
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator))).click();
        }
//
    }

    public void enterFieldValue(String locator, String text, WebDriver driver) throws InterruptedException {
//        Thread.sleep(2000);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator))).sendKeys(text);
    }

    public void selectFromMenu(String locator, String data,WebDriver driver) throws InterruptedException {
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("placeholder=\"Search company\""))).click();
//        Thread.sleep(2000);
        clickButton(locator,driver,true);
//        Thread.sleep(2000);
        clickButton(data,driver,true);

//        driver.findElement(By.name(data)).click();
    }

//    public void verifyJavaPresence(WebDriver driver,String text) {
//        String pageSource = driver.getPageSource();
//        Assert.assertTrue(pageSource.contains(text));
//    }

    public void verifyJavaPresence(String[] information, WebDriver driver) {
        String pageSource = driver.getPageSource();
        boolean isTextPresent = false;
        for (String data : information) {
            if (!pageSource.contains(data)) {
                Assert.assertFalse(false);
//                isTextPresent = true;
//                break;
            }
        }
//        Assert.assertTrue(isTextPresent);
    }

    public void verifyExperience(String range) throws InterruptedException {
//        Thread.sleep(2000);
        String[] splitRange = range.split(" - ");
        String minString = splitRange[0];
        String maxString = splitRange[1];
        int min = Integer.parseInt(minString.replaceAll("\\D", ""));
        int max = Integer.parseInt(maxString.replaceAll("\\D", ""));
//        System.out.println(min + "   " + max);
        if (min >= 1 && max <= 4) {
            Assert.fail("Experience range does not meet the criteria");
        }
    }

}
