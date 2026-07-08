package testscomplect;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.AfterAuthorizationPage;
import pages.AuthorizationPage;
import pages.HomePage;

import java.util.stream.Stream;

public class AfterAuthorizationTests extends BaseTest {

    @ParameterizedTest
    @MethodSource("authorizationData")
    public void checkGoToPersonalAccount(String browser, String email, String password) {
        setUp(browser);
        HomePage homePage = new HomePage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        AfterAuthorizationPage afterAuthorizationPage = new AfterAuthorizationPage(driver);
        homePage.clickOnPersonalAccountInHeader();
        authorizationPage.stepAuthorization(email, password);
        afterAuthorizationPage.clickOnPersonalAccountInHeader();
        Assertions.assertTrue(afterAuthorizationPage.isCheckPageProfile());
    }

    @ParameterizedTest
    @MethodSource("authorizationData")
    public void checkGoToConstructorFromProfile(String browser, String email, String password) {
        setUp(browser);
        HomePage homePage = new HomePage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        AfterAuthorizationPage afterAuthorizationPage = new AfterAuthorizationPage(driver);
        homePage.clickOnPersonalAccountInHeader();
        authorizationPage.stepAuthorization(email, password);
        afterAuthorizationPage.clickOnPersonalAccountInHeader();
        afterAuthorizationPage.clickOnGoToConstructor();
        Assertions.assertTrue(afterAuthorizationPage.isSwitchToConstructor());
    }

    @ParameterizedTest
    @MethodSource("authorizationData")
    public void checkLogoutFromProfile(String browser, String email, String password) {
        setUp(browser);
        HomePage homePage = new HomePage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        AfterAuthorizationPage afterAuthorizationPage = new AfterAuthorizationPage(driver);
        homePage.clickOnPersonalAccountInHeader();
        authorizationPage.stepAuthorization(email, password);
        afterAuthorizationPage.clickOnPersonalAccountInHeader();
        afterAuthorizationPage.clickLogoutButton();
        Assertions.assertTrue(afterAuthorizationPage.isLogoutFromProfile());
    }

    static Stream<Arguments> authorizationData() {
        return Stream.of(
                Arguments.of("chrome", "nikita2@test.ru", "qscesz135246"),
                Arguments.of("yandex", "nikita2@test.ru", "qscesz135246")
        );
    }
}
