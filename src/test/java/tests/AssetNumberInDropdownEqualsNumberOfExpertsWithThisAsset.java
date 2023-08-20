package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.CookiesStep;
import steps.ExpertsPageStep;
import steps.NavigationBarStep;
import utils.Driver;

import static utils.Driver.driver;

public class AssetNumberInDropdownEqualsNumberOfExpertsWithThisAsset {

    @BeforeMethod
    public void openHomePage() {
        Driver.initialize();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.colliers.com.au/en-au");
        CookiesStep cookiesStep = new CookiesStep();
        cookiesStep.clickAllCookies();
    }

    @Test
    public void assetClassNumberEqualsNumberOfCards() {
        NavigationBarStep navigationBarStep1 = new NavigationBarStep();
        navigationBarStep1.openExpertFinderDropdown();
        NavigationBarStep navigationBarStep2 = new NavigationBarStep();
        navigationBarStep2.goToFindAnExpert();
        ExpertsPageStep expertsPageStep1 = new ExpertsPageStep();
        expertsPageStep1.openAssetClassDropdown();
        ExpertsPageStep expertsPageStep2 = new ExpertsPageStep();
        int numOfRetail = expertsPageStep2.getNumberOfRetail();
        System.out.println(numOfRetail);
        ExpertsPageStep expertsPageStep3 = new ExpertsPageStep();
        expertsPageStep3.selectRetailAssertClass();
        ExpertsPageStep expertsPageStep4 = new ExpertsPageStep();
        int exBesidesLast = expertsPageStep4.countExpertsBesidesLast();
        ExpertsPageStep expertsPageStep5 = new ExpertsPageStep();
        int exOnLast = expertsPageStep5.countExpertsOnTheLastPage();
        int allCards = exBesidesLast + exOnLast;
        System.out.println(allCards);
        Assert.assertTrue(numOfRetail == allCards);




    }


    @AfterMethod
    public void closeBrowser (){
        driver.quit();
    }


}