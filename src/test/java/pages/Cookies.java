package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.Driver.driver;

public class Cookies {

    WebElement acceptAllCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));

    public void clickAcceptAllCookies (){
        acceptAllCookiesButton.click();
    }
}
