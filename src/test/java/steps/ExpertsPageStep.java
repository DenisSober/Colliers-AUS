package steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Constants;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.ExpertsPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static utils.Driver.driver;

public class ExpertsPageStep {

    public void openAssetClassDropdown() {
        ExpertsPage expertsPage = new ExpertsPage();
        expertsPage.openAssetClassDropdown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.SHORT_DURATION));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-value = 'Retail']/label/div/div")));
    }

    public void selectAssetRetail() {
        ExpertsPage expertsPage = new ExpertsPage();
        expertsPage.selectAssetRetailClass();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.LONG_DURATION));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title = 'Retail']")));
    }

    public int getNumberOfRetail() {
        ExpertsPage expertsPage = new ExpertsPage();
        String numberInText = expertsPage.getTextOfRetail().replaceAll("\\D", "");
        int numberOfRetail = Integer.parseInt(numberInText);
        Assert.assertTrue(numberOfRetail > -1 && numberOfRetail < 10000000);
        return numberOfRetail;
    }


    public int countExpertsBesidesLast() {
        int expertsBesideLast = 0;
        do {
            ExpertsPage expertsPage1 = new ExpertsPage();
            expertsBesideLast += expertsPage1.countExpertCardsOnOnePage();
            ExpertsPage expertsPage2 = new ExpertsPage();
            List<WebElement> list = driver.findElements(By.xpath("//li[@aria-label = 'Next']"));
            if (list.size() != 0) {
                expertsPage2.clickNextPageButton();
            }
        } while (driver.findElements(By.xpath("//li[@aria-label = 'Next']")).size() != 0);

        return expertsBesideLast;
    }

    public int countExpertsOnTheLastPage() {

        ExpertsPage expertsPage = new ExpertsPage();
        int exOnLast = expertsPage.countExpertCardsOnOnePage();
        return exOnLast;
    }

    public void selectTheLocation(String city) {
        ExpertsPage expertsPage = new ExpertsPage();
        expertsPage.openLocationDropdown();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(Constants.SHORT_DURATION));
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title = 'Adelaide']")));
        WebElement aLocation = driver.findElement(By.xpath("//span[@title = '" + city + "']"));
        aLocation.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXTRA_LONG_DURATION));
        wait.until(ExpectedConditions.attributeToBe(By.xpath("//input[@aria-label = 'Location']"), "placeholder", city));
    }

    public void compareSearchCityWithExpertCity(String city) {
        ExpertsPage expertsPage1 = new ExpertsPage();
        String firstLocation = expertsPage1.getFirstExpertLocation();
        Assert.assertTrue(city.equals(firstLocation));
    }

    public List getTestCitiesList() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> cities = new ArrayList<>();
        try {
            File jsonFile = new File("src/test/resources/locations.json");
            cities = objectMapper.readValue(jsonFile, new TypeReference<List<String>>() {
            });
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return cities;
    }

    public List getTestKeyWordsList() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> keyWords = new ArrayList<>();
        try {
            File jsonFile = new File("src/test/resources/keyWords.json");
            keyWords = objectMapper.readValue(jsonFile, new TypeReference<List<String>>() {
            });
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return keyWords;
    }

    public void clearLocationField(String city) {
        ExpertsPage expertsPage1 = new ExpertsPage();
        expertsPage1.openLocationDropdown();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(Constants.SHORT_DURATION));
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title = 'Adelaide']")));
        ExpertsPage expertsPage2 = new ExpertsPage();
        expertsPage2.uncheckLocationBox(city);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXTRA_LONG_DURATION));
        wait.until(ExpectedConditions.attributeToBe(By.xpath("//input[@aria-label = 'Location']"), "placeholder", "Location"));
    }
    public void enterTheKeyWord(String keyWord){
        ExpertsPage expertsPage1 = new ExpertsPage();
        expertsPage1.enterKeyWord(keyWord);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.LONG_DURATION));
        wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id = 'specialization-keywords']//div[@aria-label = 'Clear']"),"aria-hidden", "false"));
    }

    public void runKeyWordSearch(){
        ExpertsPage expertsPage = new ExpertsPage();
        expertsPage.clickKeyWordSearchButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXTRA_LONG_DURATION));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'coveo-result-list-container coveo-list-layout-container']/div[1]")));
    }

    public void openFirstExpertProfile(){
        ExpertsPage expertsPage = new ExpertsPage();
        expertsPage.clickFirstExpertImage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXTRA_LONG_DURATION));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id = 'expert-nav']/li[1]/a")));
    }

    public void clearKeyWordSearch(){
        ExpertsPage expertsPage = new ExpertsPage();
        expertsPage.clickClearKeyWordSearch();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(Constants.SHORT_DURATION));
        wait1.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id = 'specialization-keywords']//div[@aria-label = 'Clear']"), "aria-hidden", "true"));
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXTRA_LONG_DURATION));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'coveo-result-list-container coveo-list-layout-container']/div[1]")));
    }
}