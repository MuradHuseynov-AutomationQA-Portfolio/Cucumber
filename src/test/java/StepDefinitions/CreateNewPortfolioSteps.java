package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static common.WaitsTime.EXPLICIT_WAIT;
import static data.TestData.MyPortfolios.MY_PORTFOLIOS_PAGE;


public class CreateNewPortfolioSteps {
    static WebDriver driver;

    private final By createNewPortfolioButton = By.xpath("//div[@class='buttons-block']//button[1]");
    private final By nameField = By.xpath("//input[@id='name']");
    private final By exchangeTypeButton = By.xpath("//span[@class='exchange-icon exchange-icon_binance']//parent::*");
    private final By tokensDropdown = By.xpath("//span[text()='Add token']");
    private final By token = By.xpath("//a[@title='BRL']");
    private final By saveAndPublishButton = By.xpath("//button[@class='button button_primary button_md']");
    private final By closeIframeButton = By.xpath("//button[@class='sc-fotOHu iypTHj']");
    private final By allowAllCookiesButton = By.xpath("//button[@class='ch2-btn ch2-allow-all-btn ch2-btn-primary']");
    private String portfolioName;

    @When("Open My Portfolios page")
    public void open_my_portfolios_page() throws InterruptedException {
        driver.get(MY_PORTFOLIOS_PAGE);
        Thread.sleep(2000);
    }

    @When("Close iframe and popup")
    public void close_iframe() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeIframeButton)).click();
        } catch (Exception e) {
            System.out.println("There is no iframe");
        }
        try {
            wait.until(ExpectedConditions.elementToBeClickable(allowAllCookiesButton)).click();
        } catch (Exception e) {
            System.out.println("There is no cookies popup");
        }
    }

    @When("Click to Create New Portfolio button")
    public void click_to_create_new_portfolio_button() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(createNewPortfolioButton)).click();
    }

    @When("Enter name")
    public void enter_name() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        portfolioName = "AutoTest" + System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(portfolioName);
    }

    @When("Choose exhange type")
    public void choose_exhange_type() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(exchangeTypeButton)).click();
    }

    @When("Choose coin")
    public void choose_coin() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(tokensDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(token)).click();
    }

    @When("Click Save + Publish button")
    public void click_save_publish_button() {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndPublishButton)).click();
    }

    @Then("Check new portfolio created")
    public void check_new_portfolio_created() {
        String xpathOfElement = "//div[contains(text(),'" + portfolioName + "')]";
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathOfElement)));
    }
}
