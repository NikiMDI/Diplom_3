package googlechrometests;

import base.BaseGoogleChromeTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ConstructorPage;
import pages.HomePage;

public class ConstructorGoogleChromeTests extends BaseGoogleChromeTest {

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
