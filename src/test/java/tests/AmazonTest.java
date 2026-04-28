package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class AmazonTest {

    public WebDriver setupDriver() {

        String username = "codinggourav";
        String accessKey = "LT_fQiaEReWCTy43Kz6jEoLKbE8YFmUfIAnbJntkZC0H43KMv2";

        String hubURL =
                "https://" + username + ":" + accessKey +
                        "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("platformName", "Windows 11");

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("build", "Amazon Selenium Build");
        ltOptions.put("name", "Amazon TestNG Test");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");

        caps.setCapability("LT:Options", ltOptions);

        try {
            return new RemoteWebDriver(new URL(hubURL), caps);
        } catch (Exception e) {
            throw new RuntimeException("Unable to start LambdaTest session");
        }
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
        searchProduct("iphone");
    }

    @Test
    public void galaxyTest() {
        searchProduct("Samsung Galaxy");
    }

    @Test
    public void wirelessMouseTest() {
        searchProduct("wireless Mouse");
    }
}

