package steps;

import pages.Cookies;
import pages.HomePage;

public class CookiesStep {

    public void clickAllCookies(){
        Cookies cookies = new Cookies();
        cookies.clickAcceptAllCookies();
    }
}
