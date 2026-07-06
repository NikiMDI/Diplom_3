package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AfterAuthorizationPage {
    private WebDriver driver;

    private By clickOnPersonalAccountInHeader = By.xpath(".//p[text()='Личный Кабинет']");
    private By checkPageProfile = By.xpath(".//a[text()='Профиль']");
    private By checkGoToConstructor = By.xpath(".//p[text()='Конструктор']");
    private By checkSwitchingToConstructor = By.xpath(".//h1[text()='Соберите бургер']");
    private By logoutButton = By.xpath(".//button[text()='Выход']");
    private By checkLogoutFromProfile = By.xpath(".//h2[text()='Вход']");

    public AfterAuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке личного кабинета")
    public void clickOnPersonalAccountInHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(clickOnPersonalAccountInHeader));
        driver.findElement(clickOnPersonalAccountInHeader).click();
    }

    @Step("Проверка перехода в личный кабинет")
    public boolean isCheckPageProfile() {
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(checkPageProfile));
            return true;
        }catch (TimeoutException e){
            return false;
        }
    }

    @Step("Проверка перехода из личного кабинета в конструктор")
    public boolean isSwitchToConstructor() {
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(checkSwitchingToConstructor));
            return true;
        }catch (TimeoutException e){
            return false;
        }
    }

    @Step("Клик по кнопке перехода в раздел конструктора")
    public void clickOnGoToConstructor() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(checkGoToConstructor));
        driver.findElement(checkGoToConstructor).click();
    }

    @Step("Клик по кнопке выхода из аккаунта в профиле пользователя")
    public void clickLogoutButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }

    @Step("Проверка, что выход из профиля успешный")
    public boolean isLogoutFromProfile() {
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(checkLogoutFromProfile));
            return true;
        }catch (TimeoutException e){
            return false;
        }
    }
}
