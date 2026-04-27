package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AmazonTest {

    public WebDriver setupDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        return new ChromeDriver(options);
    }

    public void searchProduct(String product) {

        WebDriver driver = setupDriver();

        try {
            driver.get("https://www.amazon.in");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

            Thread.sleep(3000);

            WebElement searchBox = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.id("twotabsearchtextbox")));

            searchBox.click();
            searchBox.sendKeys(product);

            Thread.sleep(1500);

            searchBox.sendKeys(Keys.ENTER);

            Thread.sleep(5000);

            // CAPTCHA Check
            if (driver.getPageSource().contains("Robot Check")
                    || driver.getPageSource().contains("Enter the characters")) {

                System.out.println(product + " blocked by Amazon");
                return;
            }

            List<WebElement> products = wait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.cssSelector("div[data-component-type='s-search-result']")
                    ));

            WebElement firstProduct =
                    products.get(0).findElement(By.tagName("h2"));

            firstProduct.click();

            Thread.sleep(4000);

            // Switch tab
            for (String tab : driver.getWindowHandles()) {
                driver.switchTo().window(tab);
            }

            String price = "Price not found";

            try {
                price = driver.findElement(By.cssSelector(".a-price-whole")).getText();
            } catch (Exception ignored) {}

            System.out.println(product + " Price: ₹" + price);

            try {
                driver.findElement(By.id("add-to-cart-button")).click();
                System.out.println(product + " added to cart");
            } catch (Exception e) {
                System.out.println(product + " Add to cart unavailable");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            driver.quit();
        }
    }

    @Test
    public void iphoneTest() {
        searchProduct("iphone 17pro");
    }

    @Test
    public void galaxyTest() {
        searchProduct("Samsung Galaxy S24");
    }
}