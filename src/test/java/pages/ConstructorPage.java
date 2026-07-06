package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {
    private WebDriver driver;

    private By checkFillingButton = By.xpath(".//span[text()='Начинки']");
    private By checkFirstFillingInList = By.xpath(".//p[text()='Хрустящие минеральные кольца']");
    private By checkSaucesButton = By.xpath(".//span[text()='Соусы']");
    private By checkFirstSaucesInList = By.xpath(".//p[text()='Соус с шипами Антарианского плоскоходца']");
    private By checkFirstBreadInList = By.xpath(".//p[text()='Краторная булка N-200i']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по разделу с начинками")
    public void clickFillingButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(checkFillingButton));
        driver.findElement(checkFillingButton).click();
    }

    @Step("Проверка что перешли в раздел с начинками и виден первый элемент списка")
    public boolean isVisibilityFirstFillingInList() {
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(checkFirstFillingInList));
            driver.findElement(checkFirstFillingInList).click();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Step("Клие по разделу с соусами")
    public void clickSaucesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(checkSaucesButton));
        driver.findElement(checkSaucesButton).click();
    }

    @Step("Проверка что перешли в раздел с соусами и виден первый элемент списка")
    public boolean isVisibilityFirstSaucesInList() {
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(checkFirstSaucesInList));
            driver.findElement(checkFirstSaucesInList).click();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Step("Проверка что перешли в раздел с булками и виден первый элемент списка")
    public boolean isVisibilityFirstBreadInList() {
        try{
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(checkFirstBreadInList));
            driver.findElement(checkFirstBreadInList).click();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
