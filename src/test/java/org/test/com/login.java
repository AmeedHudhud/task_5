package org.test.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class login extends loginHelper {

    protected static WebDriver driver = new ChromeDriver();
    @BeforeMethod
    public void visitLoginPage() {
        driver.get("https://talent500.co/auth/signin?redirect_to=jobs");
        driver.manage().window().maximize();
    }
    @Test(dataProvider = "getData",dataProviderClass= dataProvider.class)
    public void logInByValidEmailAndPassword(String email, String password, boolean validCred)  {
        login(email, password,driver,validCred);
    }
    @Test(dataProvider = "getData",dataProviderClass= dataProvider.class)
    public void logInByValidEmailAndInvalidPassword(String email, String password, boolean validCred)  {
        login(email, password,driver,validCred);
    }
    @Test(dataProvider = "getData",dataProviderClass= dataProvider.class)
    public void logInByInValidEmailAndvalidPassword(String email, String password, boolean validCred)  {
        login(email, password,driver,validCred);
    }
    @Test(dataProvider = "getData",dataProviderClass= dataProvider.class)
    public void LoginWithOnlyTheEmailFieldFilled(String email, String password, boolean validCred)  {
        login(email, password,driver,validCred);
    }
    @Test(dataProvider = "getData",dataProviderClass= dataProvider.class)
    public void LoginWithOnlyThePasswordFieldFilled(String email, String password, boolean validCred)  {
        login(email, password,driver,validCred);
    }
    @Test(dataProvider = "getData",dataProviderClass= dataProvider.class)
    public void LoginWithoutEnteringEmailAndPassword(String email, String password, boolean validCred)  {
        login(email, password,driver,validCred);
    }

    @AfterClass
    public void tearDown() {
        // Quit WebDriver
        driver.quit();
    }
}
