package org.test.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class DiscoverJobs extends DiscoverJobsHelper {

    protected static WebDriver driver;
    @BeforeMethod
    public void visitSettingPage(){
        driver = new ChromeDriver();
//        driver.get("https://talent500.co/auth/signin?redirect_to=jobs");
//        login("hudhudameed@gmail.com","ameed0595",driver,true);
        driver.get("https://talent500.co/jobs");
        driver.manage().window().maximize();

//        System.out.println(driver.getPageSource());
    }
    @Test
    public void FilterJobsBySelectingASpecificSkill() throws InterruptedException {
        String[] data = {"java"};
        enterFieldValue("[placeholder=\"Search by any field (e.g skills, title, etc.)\"]","java",driver);
        clickButton("Search",driver,true);
        clickButton("View Job",driver,true);
        verifyJavaPresence(data,driver,true);
    }
    @Test
    public void FilterJobsBySelectingACompanyName() throws InterruptedException {
        String[] data = {"FedEx"};
        selectFromMenu("data-id=\"jobs-DDHeaderWrapper\"","FedEx",driver);
        clickButton("View Job",driver,true);
        verifyJavaPresence(data,driver,true);
    }
    @Test
    public void FilterJobsBySpecifyingARangeOfExperience() throws InterruptedException {
        selectFromMenu("data-id=\"DropdownHero\"","0 - 1 years",driver);
        clickButton("View Job",driver,true);
        verifyExperience("0 - 1 years");
    }

    @Test
    public void FilterJobsBySelectingAJobLocation() throws InterruptedException {
        String[] data = {"Chennai"};
        enterFieldValue("[placeholder=\"Job location\"]","Chennai",driver);
        clickButton("Search",driver,true);
        clickButton("View Job",driver,true);
        verifyJavaPresence(data,driver,true);
    }
    @Test
    public void VerifyFilteredJobsBySelectingSkillAndCompanyAndNameAndExperienceRangeAndJobLocation() throws InterruptedException {
        String []information = {"FedEx","Hyderabad","java"};
        enterFieldValue("[placeholder=\"Search by any field (e.g skills, title, etc.)\"]","java",driver);
        selectFromMenu("data-id=\"jobs-DDHeaderWrapper\"","FedEx",driver);
        selectFromMenu("data-id=\"DropdownHero\"","0 - 1 years",driver);
        enterFieldValue("[placeholder=\"Job location\"]","Hyderabad",driver);
        clickButton("Search",driver,true);
        clickButton("View Job",driver,true);
        verifyJavaPresence(information,driver,true);
        verifyExperience("0 - 1 years");
    }
    @Test
    public void FilterJobsByChoosingRemoteJobOption() throws InterruptedException {
        String []data = {"Remote"};
        clickButton("Show remote jobs",driver,true);
        clickButton("View Job",driver,true);
        verifyJavaPresence(data,driver,true);
    }
    @Test
    public void FilterCompaniesByEnteringAValidCompanyName() throws InterruptedException {
        String[] data = {"FedEx"};
        clickButton("data-id=jobs-DDHeaderWrapper",driver,false);
        enterFieldValue("[placeholder=\"Search company\"]","FedEx",driver);
        verifyJavaPresence(data,driver,true);
    }
    @Test
    public void VerifyNoCompaniesAreReturnedWhenFilteringByAnInvalidCompanyName() throws InterruptedException {
        String[] data = {"test company"};
        clickButton("data-id=jobs-DDHeaderWrapper",driver,false);
        enterFieldValue("[placeholder=\"Search company\"]","test",driver);
        verifyJavaPresence(data,driver,false);
    }
//    Filter jobs with a company that has no jobs
@Test
public void FilterJobsWithACompanyThatHasNoJobs() throws InterruptedException {
    String[] data = {"Ah, no jobs for these filters right now."};
    selectFromMenu("data-id=\"jobs-DDHeaderWrapper\"","Securonix",driver);
    verifyJavaPresence(data,driver,true);
}
    @Test
    public void FilterJobsWithASkillThatHasNoJobs() throws InterruptedException {
        String[] data = {"Ah, no jobs for these filters right now."};
        enterFieldValue("[placeholder=\"Search by any field (e.g skills, title, etc.)\"]","noJob",driver);
        clickButton("Search",driver,true);
        verifyJavaPresence(data,driver,true);
    }
    @Test
    public void FilterJobsWithAJobLocationThatHasNoJobs() throws InterruptedException {
        String[] data = {"Ah, no jobs for these filters right now."};
        enterFieldValue("[placeholder=\"Job location\"]","nablus",driver);
        clickButton("Search",driver,true);
        verifyJavaPresence(data,driver,true);
    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
