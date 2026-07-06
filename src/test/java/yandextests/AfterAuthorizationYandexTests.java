package yandextests;

import base.BaseGoogleChromeTest;
import base.BaseYandexTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.AfterAuthorizationPage;
import pages.AuthorizationPage;
import pages.HomePage;

import java.util.stream.Stream;

public class AfterAuthorizationYandexTests extends BaseYandexTest {

    @ParameterizedTest
    @MethodSource("authorizationData")
    public void checkGoToPersonalAccount(String email, String password) {
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
    public void checkGoToConstructorFromProfile(String email, String password) {
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
    public void checkLogoutFromProfile(String email, String password) {
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
                Arguments.of("nikita2@test.ru", "qscesz135246")
        );
    }
}
