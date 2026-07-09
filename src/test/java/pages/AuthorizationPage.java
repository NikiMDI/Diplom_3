package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationPage {
    private WebDriver driver;

    private By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordInput = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private By loginButton = By.xpath(".//button[text()='Войти']");
    private By formVisibility = By.xpath(".//div[@class='Auth_login__3hAey']");
    private By registrationLinkUnderForm = By.xpath(".//a[text()='Зарегистрироваться']");
    private By authorizationLinkUnderForm = By.xpath(".//a[text()='Войти']");
    private By passwordRecoveryLinkUnderForm = By.xpath(".//a[text()='Восстановить пароль']");

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод в поле электронной почты пользователя")
    public void sendEmailInput(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(emailInput));
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Ввод в поле пароля пользователя")
    public void sendPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Клик по кноке для авторизации пользователя")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Шаг авторизации")
    public void stepAuthorization(String email, String password){
        sendEmailInput(email);
        sendPasswordInput(password);
        clickLoginButton();
    }

    @Step("Клик по ссылке регистрации для появления ссылки Войти для авторизации через форму регистрацию")
    public void clickRegistrationLinkUnderForm(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registrationLinkUnderForm));
        driver.findElement(registrationLinkUnderForm).click();
    }

    @Step("Клик по ссылке Ввойти для авторизации")
    public void clickAuthorizationLinkUnderForm(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(authorizationLinkUnderForm));
        driver.findElement(authorizationLinkUnderForm).click();
    }

    @Step("Клик по ссылке восстановления пароля для появления ссылки Войти для авторизации через форму восстановления пароля")
    public void clickPasswordRecoveryLinkUnderForm(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(passwordRecoveryLinkUnderForm));
        driver.findElement(passwordRecoveryLinkUnderForm).click();
    }

    @Step("Проверка, что авторизация была успешной")
    public boolean isCheckForm(){
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.invisibilityOfElementLocated(formVisibility));
            return true;
        }catch (TimeoutException e){
            return false;
        }
    }
}
