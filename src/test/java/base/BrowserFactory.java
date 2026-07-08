package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {
    public static WebDriver getWebDriver(String browserName) {
        switch (browserName) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        "C:\\Users\\Nikita\\IdeaProjects\\Diplom_3\\google\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

                return new ChromeDriver();

            case "yandex":
                System.setProperty("webdriver.chrome.driver",
                        "C:\\Users\\Nikita\\IdeaProjects\\Diplom_3\\yandex\\chromedriver-win64\\chromedriver.exe");

                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe");

                return new ChromeDriver(options);

            default:
                throw new RuntimeException("Неизвестный браузер: " + browserName);
        }
    }
}
