package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {
    private WebDriver driver;

    private By saucesTab = By.xpath(".//span[text()='Соусы']/parent::div");
    private By fillingTab = By.xpath(".//span[text()='Начинки']/parent::div");
    private By breadTab = By.xpath(".//span[text()='Булки']/parent::div");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по разделу с начинками")
    public void clickFillingButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(fillingTab));
        driver.findElement(fillingTab).click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 2);");

        waitTabActive(fillingTab);
    }

    @Step("Проверка что перешли в раздел с начинками")
    public boolean isFillingTabActive() {
        return driver.findElement(fillingTab)
                .getAttribute("class")
                .contains("tab_tab_type_current");
    }

    @Step("Клик по разделу с соусами")
    public void clickSaucesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(saucesTab));
        driver.findElement(saucesTab).click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 2);");

        waitTabActive(saucesTab);
    }

    @Step("Проверка что перешли в раздел с соусами")
    public boolean isSaucesTabActive() {
        return driver.findElement(saucesTab)
                .getAttribute("class")
                .contains("tab_tab_type_current");
    }

    @Step("Клик по разделу с булками")
    public void clickBreadButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(breadTab));
        driver.findElement(breadTab).click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight / 2);");

        waitTabActive(breadTab);
    }

    @Step("Проверка что перешли в раздел с булками")
    public boolean isBreadTabActive() {
        return driver.findElement(breadTab)
                .getAttribute("class")
                .contains("tab_tab_type_current");
    }

    private void waitTabActive(By tab) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(
                        tab,
                        "class",
                        "tab_tab_type_current"
                ));
    }
}
