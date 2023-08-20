package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.CookiesStep;
import steps.ExpertProfileStep;
import steps.ExpertsPageStep;
import steps.NavigationBarStep;
import utils.Driver;

import static utils.Driver.driver;

public class SearchExpertsByMultiFilterLocationAssetService {

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
        expertsPageStep3.openLocationDropdown();
        ExpertsPageStep expertsPageStep4 = new ExpertsPageStep();
        expertsPageStep4.selectAdelaideLocation();
        ExpertsPageStep expertsPageStep5 = new ExpertsPageStep();
        expertsPageStep5.openAssetClassDropdown();
        ExpertsPageStep expertsPageStep6 = new ExpertsPageStep();
        expertsPageStep6.selectRetailAssertClass();
        ExpertsPageStep expertsPageStep7 = new ExpertsPageStep();
        expertsPageStep7.openServiceDropdown();
        ExpertsPageStep expertsPageStep8 = new ExpertsPageStep();
        expertsPageStep8.selectRealEstateManagementService();
        ExpertsPageStep expertsPageStep9 = new ExpertsPageStep();
        expertsPageStep9.openFirstExpertProfile();
        ExpertProfileStep expertProfileStep9 = new ExpertProfileStep();
        String expertLocation = expertProfileStep9.getExpertLocation();
        Assert.assertEquals(expertLocation, "Adelaide");
        ExpertProfileStep expertProfileStep10 = new ExpertProfileStep();
        String expertPropertyType = expertProfileStep10.getExpertPropertyType();
        Assert.assertTrue(expertPropertyType.contains("Retail"));
        ExpertProfileStep expertProfileStep11 = new ExpertProfileStep();
        String expertServiceLines = expertProfileStep11.getExpertServiceLines();
        Assert.assertTrue(expertServiceLines.contains("Real Estate Management Services"));



    }

    @AfterMethod
    public void closeBrowser (){
        driver.quit();
    }

}


