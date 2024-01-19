package StepDefinitions;

import io.cucumber.java.After;

import static StepDefinitions.CreateNewPortfolioSteps.driver;

public class AfterSteps {
    @After
    public void tearDown() {
        driver.close();
    }
}
