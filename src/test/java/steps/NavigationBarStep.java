package steps;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.NavigationBar;

import java.time.Duration;

import static utils.Driver.driver;

public class NavigationBarStep {

    public void openExpertFinderDropdown (){
        NavigationBar navigationBar = new NavigationBar();
        navigationBar.clickExpertFinderDropDown();
        WebDriverWait waitTitle = new WebDriverWait(driver, Duration.ofSeconds(Constants.SHORT_DURATION));
        waitTitle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Expert Finder')]")));
    }

    public void goToFindAnExpert() {
        NavigationBar navigationBar = new NavigationBar();
        navigationBar.clickFindAnExpertButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXTRA_LONG_DURATION));
        String expectedUrl = "https://www.colliers.com.au/en-au/experts#sort=%40firstz32xname%20ascending";
        wait.until(ExpectedConditions.and(
                ExpectedConditions.urlToBe(expectedUrl),
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'coveo-result-list-container coveo-list-layout-container']/div[30]"))));


    }
}
