package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    private By clickOnPersonalAccountInHeader = By.xpath(".//p[text()='Личный Кабинет']");
    private By clickLoginAccountButton = By.cssSelector("div button[class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по 'Личный кабинет'")
    public void clickOnPersonalAccountInHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(clickOnPersonalAccountInHeader));
        driver.findElement(clickOnPersonalAccountInHeader).click();
    }

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickOnLoginAccountButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(clickLoginAccountButton));
        driver.findElement(clickLoginAccountButton).click();
    }
}
