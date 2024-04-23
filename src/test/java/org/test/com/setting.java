package org.test.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class setting extends settingHelper{

    protected static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void visitSettingPage(){
        driver.get("https://talent500.co/auth/signin?redirect_to=jobs");
        login("hudhudameed@gmail.com","ameed0595",driver,true);
        driver.get("https://talent500.co/account-settings");

    }
    @Test
    public void test() throws InterruptedException {
        changePassword("ameed0595","ameed0595","ameed059588",driver);
    }
    @Test
    public void test1() throws InterruptedException {
        changePassword("ameed0595","ameed0595","ameed059588",driver);
    }
    @Test
    public void test2() throws InterruptedException {
        changePassword("ameed0595","ameed0595","ameed059588",driver);
    }
    @Test
    public void test3() throws InterruptedException {
        changePassword("ameed0595","ameed0595","ameed059588",driver);
    }


}
