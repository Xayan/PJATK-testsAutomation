package pl.xayan.tau5.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AutomationSteps {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private String email;
    private String password;

    public AutomationSteps() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driverWait = new WebDriverWait(driver, 5);
    }

    @Given("^I am on the website$")
    public void i_am_on_the_website() throws Throwable {
        driver.get("http://automationpractice.com/index.php");
    }

    @Given("^email is (.+)$")
    public void email_is(String email) throws Throwable {
        this.email = email;
    }

    @Given("^password is (.+)$")
    public void password_is(String password) throws Throwable {
        this.password = password;
    }

    @When("^I sign in$")
    public void i_sign_in() throws Throwable {
        driver.findElement(By.linkText("Sign in")).click();

        driver.findElement(By.id("email")).sendKeys(this.email);
        driver.findElement(By.id("passwd")).sendKeys(this.password);
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @When("^I sign up$")
    public void i_sign_up() throws Throwable {
        driver.findElement(By.linkText("Sign in")).click();

        // Generate a random e-mail address
        Random random = new Random();
        String email = "tau_sampleuser_" + random.nextInt() + "@example" + random.nextInt() + ".com";
        System.out.println(email);

        driverWait.until(ExpectedConditions.elementToBeClickable(By.id("email_create")));

        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();

        driverWait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Test");
        driver.findElement(By.id("customer_lastname")).sendKeys("Test");
        driver.findElement(By.id("passwd")).sendKeys("password");
        driver.findElement(By.id("firstname")).sendKeys("Test");
        driver.findElement(By.id("lastname")).sendKeys("Test");
        driver.findElement(By.id("address1")).sendKeys("Test");
        driver.findElement(By.id("city")).sendKeys("Test");
        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.id("phone_mobile")).sendKeys("123456789");

        Select select = new Select(driver.findElement(By.id("id_state")));
        select.selectByIndex(1);

        driverWait.until(ExpectedConditions.elementToBeClickable(By.id("submitAccount")));

        driver.findElement(By.id("submitAccount")).click();
    }

    @When("^I sign up without data$")
    public void i_sign_up_without_data() throws Throwable {
        driver.findElement(By.linkText("Sign in")).click();

        // Generate a random e-mail address
        Random random = new Random();
        String email = "tau_sampleuser_" + random.nextInt() + "@example" + random.nextInt() + ".com";
        System.out.println(email);

        driverWait.until(ExpectedConditions.elementToBeClickable(By.id("email_create")));

        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();

        driverWait.until(ExpectedConditions.elementToBeClickable(By.id("submitAccount")));

        driver.findElement(By.id("submitAccount")).click();
    }

    @Then("^I am logged in$")
    public void i_am_logged_in() throws Throwable {
        WebElement signOutElement = driver.findElement(By.linkText("Sign out"));

        assertNotNull(signOutElement);

        signOutElement.click();
        driver.close();
    }

    @Then("^there is an error$")
    public void there_is_an_error() throws Throwable {
        assertNotNull(driver.findElement(By.className("alert")));

        driver.close();
    }

    @Given("^browser resolution is (.+) x (.+)$")
    public void browserResolutionIsWidthXHeight(Integer width, Integer height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }
}
