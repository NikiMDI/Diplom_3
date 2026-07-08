package testscomplect;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.HomePage;
import pages.RegistrationPage;

import java.util.stream.Stream;

public class RegistrationTests extends BaseTest {
    @ParameterizedTest
    @MethodSource("userDataProvider")
    public void checkRegistrationUserThroughInHeaderButton(String browser, String userName, String userEmail, String userPassword) {
        setUp(browser);
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        homePage.clickOnPersonalAccountInHeader();
        registrationPage.stepRegistration(userName, userEmail, userPassword);
        Assertions.assertTrue(registrationPage.isCorrectLoginCheck());
    }

    @ParameterizedTest
    @MethodSource("userDataProvider")
    public void checkRegistrationUserThroughAccountButton(String browser, String userName, String userEmail, String userPassword) {
        setUp(browser);
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
                        "chrome",
                        faker.name().firstName(),
                        faker.internet().emailAddress(),
                        faker.internet().password(6, 10)
                ),
                Arguments.of(
                        "chrome",
                        faker.name().firstName(),
                        "invalid_email_",
                        faker.internet().password(6, 10)
                ),
                Arguments.of(
                        "chrome",
                        faker.name().firstName(),
                        faker.internet().emailAddress(),
                        faker.internet().password(1, 5)
                ),
                Arguments.of(
                        "chrome",
                        "",
                        faker.internet().emailAddress(),
                        faker.internet().password(6, 10)
                ),
                Arguments.of(
                        "yandex",
                        faker.name().firstName(),
                        faker.internet().emailAddress(),
                        faker.internet().password(6, 10)
                ),
                Arguments.of(
                        "yandex",
                        faker.name().firstName(),
                        "invalid_email_",
                        faker.internet().password(6, 10)
                ),
                Arguments.of(
                        "yandex",
                        faker.name().firstName(),
                        faker.internet().emailAddress(),
                        faker.internet().password(1, 5)
                ),
                Arguments.of(
                        "yandex",
                        "",
                        faker.internet().emailAddress(),
                        faker.internet().password(6, 10)
                )
        );
    }
}
