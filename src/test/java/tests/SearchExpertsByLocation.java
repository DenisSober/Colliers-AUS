package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.CookiesStep;
import steps.ExpertsPageStep;
import steps.NavigationBarStep;
import utils.Driver;

import java.util.Iterator;
import java.util.List;

import static utils.Driver.driver;

public class SearchExpertsByLocation {

    @BeforeMethod
    public void openHomePage() {
        Driver.initialize();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.colliers.com.au/en-au");
        CookiesStep cookiesStep = new CookiesStep();
        cookiesStep.clickAllCookies();
    }

    @Test
    public void testSearchByLocation () {
        NavigationBarStep navigationBarStep1 = new NavigationBarStep();
        navigationBarStep1.openExpertFinderDropdown();
        NavigationBarStep navigationBarStep2 = new NavigationBarStep();
        navigationBarStep2.goToFindAnExpert();
        ExpertsPageStep expertsPageStep1 = new ExpertsPageStep();
        List<String> cities = expertsPageStep1.getTestCitiesList();
        Iterator<String> iterator = cities.iterator();
        while (iterator.hasNext()) {
            String city = iterator.next();
            ExpertsPageStep expertsPageStep2 = new ExpertsPageStep();
            expertsPageStep2.selectTheLocation(city);
            ExpertsPageStep expertsPageStep3 = new ExpertsPageStep();
            expertsPageStep3.compareSearchCityWithExpertCity(city);
            ExpertsPageStep expertsPageStep4 = new ExpertsPageStep();
            expertsPageStep4.clearLocationField(city);
        }


    }
    @AfterMethod
    public void closeBrowser (){
        driver.quit();
    }
}
