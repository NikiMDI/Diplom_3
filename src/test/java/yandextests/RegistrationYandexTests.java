package yandextests;

import base.BaseGoogleChromeTest;
import base.BaseYandexTest;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.HomePage;
import pages.RegistrationPage;

import java.util.stream.Stream;

public class RegistrationYandexTests extends BaseYandexTest {
    @ParameterizedTest
    @MethodSource("userDataProvider")
    public void checkRegistrationUserThroughInHeaderButton(String userName, String userEmail, String userPassword) {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        homePage.clickOnPersonalAccountInHeader();
        registrationPage.stepRegistration(userName, userEmail, userPassword);
        Assertions.assertTrue(registrationPage.isCorrectLoginCheck());
    }

    @ParameterizedTest
    @MethodSource("userDataProvider")
    public void checkRegistrationUserThroughAccountButton(String userName, String userEmail, String userPassword) {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        homePage.clickOnLoginAccountButton();
        registrationPage.stepRegistration(userName, userEmail, userPassword);
        Assertions.assertTrue(registrationPage.isCorrectLoginCheck());
    }

    static Stream<Arguments> userDataProvider() {
        Faker faker = new Faker();

        return Stream.of(
                Arguments.of(
                        faker.name().firstName(),
                        faker.internet().emailAddress(),
                        faker.internet().password(6, 10)
                ),
                Arguments.of(
                        faker.name().firstName(),
                        "invalid_email_",
                        faker.internet().password(6, 10)
                ),
                Arguments.of(
                        faker.name().firstName(),
                        faker.internet().emailAddress(),
                        faker.internet().password(1, 5)
                ),
                Arguments.of(
                        "",
                        faker.internet().emailAddress(),
                        faker.internet().password(6, 10)
                )
        );
    }
}
