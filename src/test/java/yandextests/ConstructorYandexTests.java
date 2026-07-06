package yandextests;

import base.BaseGoogleChromeTest;
import base.BaseYandexTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ConstructorPage;

public class ConstructorYandexTests extends BaseYandexTest {

    @Test
    public void checkGoToFillingSection(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickFillingButton();
        Assertions.assertTrue(constructorPage.isVisibilityFirstFillingInList());
    }

    @Test
    public void checkGoToSaucesSection(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.clickSaucesButton();
        Assertions.assertTrue(constructorPage.isVisibilityFirstSaucesInList());
    }

    @Test
    public void checkFoToBreadSection(){
        ConstructorPage constructorPage = new ConstructorPage(driver);
        Assertions.assertTrue(constructorPage.isVisibilityFirstBreadInList());
    }
}
