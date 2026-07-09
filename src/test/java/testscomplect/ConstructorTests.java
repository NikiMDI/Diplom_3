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
        Assertions.assertTrue(constructorPage.isFillingTabActive());
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "yandex"})
    public void checkGoToSaucesSection(String browser){
        setUp(browser);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickSaucesButton();
        Assertions.assertTrue(constructorPage.isSaucesTabActive());
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "yandex"})
    public void checkGoToBreadSection(String browser) {
        setUp(browser);
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickSaucesButton();
        Assertions.assertFalse(constructorPage.isBreadTabActive());
        constructorPage.clickBreadButton();
        Assertions.assertTrue(constructorPage.isBreadTabActive());
    }
}
