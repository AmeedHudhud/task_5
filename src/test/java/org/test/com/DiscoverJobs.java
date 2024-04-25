package org.test.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DiscoverJobs extends DiscoverJobsHelper {
/*
 *  enter field value(locator)
 *  click button()
 *  verify information
 */
    protected static WebDriver driver;
    @BeforeMethod
    public void visitSettingPage(){
        driver = new ChromeDriver();
        driver.get("https://talent500.co/auth/signin?redirect_to=jobs");
        login("hudhudameed@gmail.com","ameed0595",driver,true);
        driver.get("https://talent500.co/jobs");
        driver.manage().window().maximize();
    }
    @Test
    public void FilterJobsBySelectingASpecificSkill() throws InterruptedException {
        enterFieldValue("[placeholder=\"Search by any field (e.g skills, title, etc.)\"]","java",driver);
        clickButton("Search",driver,true);
        clickButton("View Job",driver,true);
//        verifyJavaPresence({"java"},driver);
    }

    @Test
    public void FilterJobsBySelectingACompanyName() throws InterruptedException {
        selectFromMenu("Company","HME",driver);
        clickButton("View Job",driver,true);
//        verifyJavaPresence(driver,"HME");
    }

    @Test
    public void FilterJobsBySpecifyingARangeOfExperience() throws InterruptedException {
        selectFromMenu("Experience","0 - 1 years",driver);
        clickButton("View Job",driver,true);
        verifyExperience("0 - 1 years");
    }

    @Test
    public void FilterJobsBySelectingAJobLocation() throws InterruptedException {
        enterFieldValue("[placeholder=\"Job location\"]","Chennai",driver);
        clickButton("Search",driver,true);
        clickButton("View Job",driver,true);
//        verifyJavaPresence(driver,"Chennai");
    }
    @Test
    public void VerifyFilteredJobsBySelectingSkillAndCompanyAndNameAndExperienceRangeAndJobLocation() throws InterruptedException {
        String []information = {"FedEx","Hyderabad","cypress"};
        enterFieldValue("[placeholder=\"Search by any field (e.g skills, title, etc.)\"]","java",driver);
        selectFromMenu("Company","FedEx",driver);
        selectFromMenu("Experience","0 - 1 years",driver);
        enterFieldValue("[placeholder=\"Job location\"]","Hyderabad",driver);
        clickButton("Search",driver,true);
        clickButton("View Job",driver,true);
        verifyJavaPresence(information,driver);
//        verifyJavaPresence(driver,"FedEx");
        verifyExperience("0 - 1 years");
//        verifyJavaPresence(driver,"Hyderabad");
    }






//    @AfterMethod
//    public void quit(){
//        driver.quit();
//    }
}
