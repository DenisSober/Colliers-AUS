package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.CookiesStep;
import steps.NavigationBarStep;
import utils.Driver;

import static utils.Driver.driver;

public class ExpertFinderCanBeOpened {

    @BeforeMethod
    public void openHomePage (){
        Driver.initialize();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.colliers.com.au/en-au");
        CookiesStep cookiesStep = new CookiesStep();
        cookiesStep.clickAllCookies();
    }

    @Test
    public void testOpenExpertFinder (){
        NavigationBarStep navigationBarStep= new NavigationBarStep();
        navigationBarStep.openExpertFinderDropdown();
    }

    @AfterMethod
    public void closeBrowser (){
        driver.quit();
    }
}
