package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import static utils.Driver.driver;

public class ExpertsPage {

    private final WebElement assetClassDropdown = driver.findElement(By.xpath("//div[@class = 'custom-facet']/div[@id = 'PropertyType']/div[1]/div[1]/div[3]/span"));
    private final String assetRetailClassLoc = "//span[@title = 'Retail']";
    private final WebElement firstExpertCard = driver.findElement(By.xpath("//div[@class = 'coveo-result-list-container coveo-list-layout-container']/div[1]"));

    private final WebElement firstExpertImage = driver. findElement(By.xpath("//div[@class = 'coveo-result-list-container coveo-list-layout-container']/div[1]//img"));
    private final WebElement expertsContainer = driver.findElement(By.xpath("//div[@class = 'coveo-result-list-container coveo-list-layout-container']"));
    private final String nextPageButtonLock = "//li[@aria-label = 'Next']";

    private final WebElement keyWordsSearchField = driver.findElement(By.xpath("//input[@placeholder = 'Keywords']"));

    private final WebElement cleanKeyWordSearchButton = driver.findElement(By.xpath("//div[@id = 'specialization-keywords']//div[@aria-label = 'Clear']"));
    private final WebElement firstExpertLocation = driver.findElement(By.xpath("//div[@class = 'coveo-result-list-container coveo-list-layout-container']/div[1]//p[@class = 'expert-office']"));

    private final WebElement keyWordsSearchButton = driver. findElement(By.xpath("//div[@id = 'specialization-keywords_container']//a[@aria-label = 'Search']"));
    private final WebElement locationDropDown = driver.findElement(By.xpath("//div[@id = 'location']/div[@class = 'coveo-facet-header']/div/div[3]/span"));


    public void openAssetClassDropdown() {
        assetClassDropdown.click();
    }

    public void clickNextPageButton() {
        driver.findElement(By.xpath(nextPageButtonLock)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.LONG_DURATION));
        By expertOne = By.xpath("//div[@class = 'coveo-result-list-container coveo-list-layout-container']/div[1]");
        wait.until(ExpectedConditions.presenceOfElementLocated(expertOne));
    }

    public void selectAssetRetailClass() {
        driver.findElement(By.xpath(assetRetailClassLoc)).click();
    }

    public String getTextOfRetail() {
        String retailText = driver.findElement(By.xpath(assetRetailClassLoc)).getText();
        return retailText;

    }

    public int countExpertCardsOnOnePage() {
        int cardsOnThisPage;
        if (firstExpertCard.isDisplayed()) {
            List<WebElement> cards = expertsContainer.findElements(By.xpath("//div[@class = 'coveo-list-layout CoveoResult']"));
            cardsOnThisPage = cards.size();
            return cardsOnThisPage;
        } else cardsOnThisPage = 0;
        return cardsOnThisPage;
    }

    public String getFirstExpertLocation() {
        String expertLocation = firstExpertLocation.getText();
        return expertLocation;
    }

    public void openLocationDropdown() {
        locationDropDown.click();
    }

    public void uncheckLocationBox(String city) {
        WebElement anyLocationBox = driver.findElement(By.xpath("//span[@title = '" + city + "']"));
        anyLocationBox.click();
    }

    public void enterKeyWord(String keyWord) {
        keyWordsSearchField.sendKeys(keyWord);
    }

    public void clickKeyWordSearchButton(){
        keyWordsSearchButton.click();
    }

    public void clickFirstExpertImage(){
        firstExpertImage.click();
    }

    public void clickClearKeyWordSearch(){
        cleanKeyWordSearchButton.click();
    }
}