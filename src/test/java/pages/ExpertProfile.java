package pages;

import org.testng.Assert;

import static utils.Driver.driver;

public class ExpertProfile {

    public String getPageSource (){
        String pageSource = driver.getPageSource();
        return pageSource;
    }

public void getBackFromExpertProfile(){
        driver.navigate().back();
}
}
