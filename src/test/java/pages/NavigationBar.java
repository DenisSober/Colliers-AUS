package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.Driver.driver;

public class NavigationBar {

    private final WebElement expertFinderDropdown = driver.findElement(By.xpath("//a[contains(text(), 'Expert Finder')]"));

    private final WebElement findAnExpertButton = driver.findElement(By.xpath("//div[@class = 'megamenu__level-one__toggle']//a[@href = '/en-au/experts']"));

    public void clickExpertFinderDropDown() {
        expertFinderDropdown.click();
    }

    public void clickFindAnExpertButton () {
        findAnExpertButton.click();
    }
}
