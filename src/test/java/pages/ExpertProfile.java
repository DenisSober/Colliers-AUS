package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Driver.driver;

public class ExpertProfile {

    private final WebElement expertLocationInfo = driver.findElement(By.xpath("//span[@class = 'location-text']"));

    private final WebElement propertyTypeInfo = driver.findElement(By.xpath("//h4[contains(text(), 'Property')]/..//div"));

    private final WebElement serviceLinesInfo = driver.findElement(By.xpath("//h4[contains(text(), 'Service')]/..//div"));
    public String readExpertLocation() {
         return expertLocationInfo.getText();
    }

    public String readExpertPropertyType() {
        return propertyTypeInfo.getText();
    }

    public String readExpertServiceLines() {
        return serviceLinesInfo.getText();
    }

    public String getPageSource (){
        return driver.getPageSource();
    }

public void getBackFromExpertProfile(){
        driver.navigate().back();
}
}
