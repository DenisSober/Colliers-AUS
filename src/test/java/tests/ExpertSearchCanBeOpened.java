package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.CookiesStep;
import steps.ExpertsPageStep;
import steps.NavigationBarStep;
import utils.Driver;
import java.time.Duration;

import static utils.Driver.driver;

public class ExpertSearchCanBeOpened {

    @BeforeMethod
    public void openHomePage (){
        Driver.initialize();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.colliers.com.au/en-au");
        CookiesStep cookiesStep = new CookiesStep();
        cookiesStep.clickAllCookies();
    }

    @Test
    public void testOpenExpertSearch (){
        NavigationBarStep navigationBarStep1 = new NavigationBarStep();
        navigationBarStep1.openExpertFinderDropdown();
        NavigationBarStep navigationBarStep2 = new NavigationBarStep();
        navigationBarStep2.goToFindAnExpert();
        ExpertsPageStep expertsPageStep3 = new ExpertsPageStep();
        expertsPageStep3.openAssetClassDropdown();
        ExpertsPageStep expertsPageStep4 = new ExpertsPageStep();
        expertsPageStep4.selectAssetRetail();
    }

    @AfterMethod
    public void closeBrowser (){
        driver.quit();
    }

}


