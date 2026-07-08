package base;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;
    protected static final String BASE_URL = "https://qa-stellarburgers.education-services.ru/";

    protected void setUp(String browser) {
        driver = BrowserFactory.getWebDriver(browser);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
