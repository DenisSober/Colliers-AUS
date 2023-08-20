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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.SHORT_DURATION));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Expert Finder')]")));
    }

    public void goToFindAnExpert() {
        NavigationBar navigationBar = new NavigationBar();
        navigationBar.clickFindAnExpertButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.SHORT_DURATION));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains (@class, 'coveo-result')]/div[30]")));


    }
}
