package StepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.Cookie;

import static common.CommonActions.createDriver;
import static data.TestData.SignInTestData.SESSION_ID_KEY;
import static data.TestData.SignInTestData.SESSION_ID_VALUE;
import static data.TestData.URLs.AUTH_URL;
import static StepDefinitions.CreateNewPortfolioSteps.driver;

public class BeforeSteps {
    @Given("Open 3commas page")
    public void openUrl(){
        driver = createDriver();
        driver.get(AUTH_URL);
    }
    @Given("Sign in")
    public void sign_in() {
        Cookie authCookie = new Cookie(SESSION_ID_KEY, SESSION_ID_VALUE);
        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();
    }
}
