package testscomplect;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.ConstructorPage;

public class ConstructorTests extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "yandex"})
    public void checkGoToFillingSection(String browser){
        setUp(browser);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickFillingButton();
        Assertions.assertTrue(constructorPage.isVisibilityFirstFillingInList());
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "yandex"})
    public void checkGoToSaucesSection(String browser){
        setUp(browser);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickSaucesButton();
        Assertions.assertTrue(constructorPage.isVisibilityFirstSaucesInList());
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "yandex"})
    public void checkFoToBreadSection(String browser){
        setUp(browser);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        Assertions.assertTrue(constructorPage.isVisibilityFirstBreadInList());
    }
}
