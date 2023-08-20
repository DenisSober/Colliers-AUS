package steps;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.ExpertProfile;

import java.time.Duration;
import java.util.Locale;

import static utils.Driver.driver;

public class ExpertProfileStep {

    public String getExpertLocation(){
        ExpertProfile expertProfile = new ExpertProfile();
        return expertProfile.readExpertLocation();
    }

    public String getExpertPropertyType(){
        ExpertProfile expertProfile = new ExpertProfile();
        return expertProfile.readExpertPropertyType();
    }

    public String getExpertServiceLines(){
        ExpertProfile expertProfile = new ExpertProfile();
        return expertProfile.readExpertServiceLines();
    }

    public void checkIfKeyWordExistInProfile (String keyWord){
        ExpertProfile expertProfile = new ExpertProfile();
        String pageText = expertProfile.getPageSource().toLowerCase();
        Assert.assertTrue(pageText.contains(keyWord));
    }

    public void getBackFromExProfileToExperts(){
        ExpertProfile expertProfile = new ExpertProfile();
        expertProfile.getBackFromExpertProfile();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXTRA_LONG_DURATION));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'coveo-result-list-container coveo-list-layout-container']/div[1]//img")));
    }
}
