package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ExpertProfile;
import steps.CookiesStep;
import steps.ExpertProfileStep;
import steps.ExpertsPageStep;
import steps.NavigationBarStep;
import utils.Driver;

import java.util.Iterator;
import java.util.List;

import static utils.Driver.driver;

public class ExpertsSearchByKeyWords {

    @BeforeMethod
    public void openHomePage() {
        Driver.initialize();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.colliers.com.au/en-au");
        CookiesStep cookiesStep = new CookiesStep();
        cookiesStep.clickAllCookies();
    }

    @Test
    public void expertsSearchByKeyWords() {
        NavigationBarStep navigationBarStep1 = new NavigationBarStep();
        navigationBarStep1.openExpertFinderDropdown();
        NavigationBarStep navigationBarStep2 = new NavigationBarStep();
        navigationBarStep2.goToFindAnExpert();
        ExpertsPageStep expertsPageStep1 = new ExpertsPageStep();
        List<String> keyWords = expertsPageStep1.getTestKeyWordsList();
        Iterator<String> iterator = keyWords.iterator();
        while (iterator.hasNext()) {
            String keyWord = iterator.next();
            ExpertsPageStep expertsPageStep2 = new ExpertsPageStep();
            expertsPageStep2.enterTheKeyWord(keyWord);
            ExpertsPageStep expertsPageStep3 = new ExpertsPageStep();
            expertsPageStep3.runKeyWordSearch();
            ExpertsPageStep expertsPageStep4 = new ExpertsPageStep();
            expertsPageStep4.openFirstExpertProfile();
            ExpertProfileStep expertProfileStep1 = new ExpertProfileStep();
            expertProfileStep1.checkIfKeyWordExistInProfile(keyWord);
            ExpertProfileStep expertProfileStep2 = new ExpertProfileStep();
            expertProfileStep2.getBackFromExProfileToExperts();
            ExpertsPageStep expertsPageStep5 = new ExpertsPageStep();
            expertsPageStep5.clearKeyWordSearch();


        }
    }

    @AfterMethod
    public void closeBrowser (){
        driver.quit();
    }
}