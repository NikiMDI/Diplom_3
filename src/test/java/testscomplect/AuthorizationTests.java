package testscomplect;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.AuthorizationPage;
import pages.HomePage;

import java.util.stream.Stream;

public class AuthorizationTests extends BaseTest {
    @ParameterizedTest
    @MethodSource("authorizationData")
    public void checkAuthorizationThroughInHeaderButton(String browser, String email, String password) {
        setUp(browser);
        HomePage homePage = new HomePage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        homePage.clickOnPersonalAccountInHeader();
        authorizationPage.stepAuthorization(email, password);
        Assertions.assertTrue(authorizationPage.isCheckForm());
    }

    @ParameterizedTest
    @MethodSource("authorizationData")
    public void checkAuthorizationThroughAccountButton(String browser, String email, String password) {
        setUp(browser);
        HomePage homePage = new HomePage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        homePage.clickOnLoginAccountButton();
        authorizationPage.stepAuthorization(email, password);
        Assertions.assertTrue(authorizationPage.isCheckForm());
    }

    @ParameterizedTest
    @MethodSource("authorizationData")
    public void checkAutrorizationInHeaderButtonThoughRegistrationForm(String browser, String email, String password) {
        setUp(browser);
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
    public void checkAutrorizationInHeaderButtonThoughPasswordRecovery(String browser, String email, String password) {
        setUp(browser);
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
                Arguments.of("chrome", "nikita2@test.ru", "qscesz135246"),
                Arguments.of("chrome", "nikita3@test.ru", "qscesz135246"),
                Arguments.of("yandex", "nikita2@test.ru", "qscesz135246"),
                Arguments.of("yandex", "nikita3@test.ru", "qscesz135246")
        );
    }
}
