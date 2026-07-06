package yandextests;

import base.BaseGoogleChromeTest;
import base.BaseYandexTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.AuthorizationPage;
import pages.HomePage;

import java.util.stream.Stream;

public class AuthorizationYandexTests extends BaseYandexTest {
    @ParameterizedTest
    @MethodSource("authorizationData")
    public void checkAuthorizationThroughInHeaderButton(String email, String password) {
        HomePage homePage = new HomePage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        homePage.clickOnPersonalAccountInHeader();
        authorizationPage.stepAuthorization(email, password);
        Assertions.assertTrue(authorizationPage.isCheckForm());
    }

    @ParameterizedTest
    @MethodSource("authorizationData")
    public void checkAuthorizationThroughAccountButton(String email, String password) {
        HomePage homePage = new HomePage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        homePage.clickOnLoginAccountButton();
        authorizationPage.stepAuthorization(email, password);
        Assertions.assertTrue(authorizationPage.isCheckForm());
    }

    @ParameterizedTest
    @MethodSource("authorizationData")
    public void checkAutrorizationInHeaderButtonThoughRegistrationForm(String email, String password) {
        HomePage homePage = new HomePage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        homePage.clickOnPersonalAccountInHeader();
        authorizationPage.clickRegistrationLinkUnderForm();
        authorizationPage.clickAuthorizationLinkUnderForm();
        authorizationPage.stepAuthorization(email, password);
        Assertions.assertTrue(authorizationPage.isCheckForm());
    }

    @ParameterizedTest
    @MethodSource("authorizationData")
    public void checkAutrorizationInHeaderButtonThoughPasswordRecovery(String email, String password) {
        HomePage homePage = new HomePage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        homePage.clickOnPersonalAccountInHeader();
        authorizationPage.clickPasswordRecoveryLinkUnderForm();
        authorizationPage.clickAuthorizationLinkUnderForm();
        authorizationPage.stepAuthorization(email, password);
        Assertions.assertTrue(authorizationPage.isCheckForm());
    }

    static Stream<Arguments> authorizationData() {
        return Stream.of(
                Arguments.of("nikita2@test.ru", "qscesz135246"),
                Arguments.of("nikita3@test.ru", "qscesz135246")
        );
    }
}
