package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.Driver.driver;

public class NavigationBar {

    private final WebElement expertFinderDropdown = driver.findElement(By.xpath("//a[contains(text(), 'Expert Finder')]"));

    private final WebElement findAnExpertButton = driver.findElement(By.xpath("//div[@id = 'l0nav-3']//a[contains(text(), 'Find an Expert')]"));

    public void clickExpertFinderDropDown() {
        expertFinderDropdown.click();
    }

    public void clickFindAnExpertButton () {
        findAnExpertButton.click();
    }
}
