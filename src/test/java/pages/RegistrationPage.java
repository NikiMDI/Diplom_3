package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;

    private By registrationLinkUnderForm = By.xpath(".//a[text()='Зарегистрироваться']");
    private By nameInput = By.xpath("//label[text()='Имя']/following-sibling::input");
    private By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordInput = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By isCorrectLigon = By.xpath(".//h2[text()='Вход']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по ссылке регистрации")
    public void clickRegistrationLink() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registrationLinkUnderForm));
        driver.findElement(registrationLinkUnderForm).click();
    }

    @Step("Ввод в поле имени пользователя")
    public void sendNameInput(String name){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(nameInput));
        driver.findElement(nameInput).sendKeys(name);
    }

    @Step("Ввод в поле электронной почты пользователя")
    public void sendEmailInput(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Ввод в поле пароля пользователя")
    public void sendPasswordInput(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Клик по кнопке регистрации пользователя после заполнения данных")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Проверка, что регистрация была успешной")
    public boolean isCorrectLoginCheck() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(isCorrectLigon));
            return true;
        }catch (TimeoutException e){
            return false;
        }
    }

    @Step("Шаг регистрации")
    public void stepRegistration(String name, String email, String password){
        clickRegistrationLink();
        sendNameInput(name);
        sendEmailInput(email);
        sendPasswordInput(password);
        clickRegistrationButton();
    }
}
