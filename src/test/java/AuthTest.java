import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import pages.MainPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static pages.TestPages.mainPage;

@Owner("Alex156qa")
@Feature("Авторизация")
public class AuthTest {

    @BeforeEach
    public void setup() {
        open("https://github.com/");
        mainPage.mainSignInButton.click();
    }

    @Test
    @Story("Авторизация")
    @DisplayName("Авторизация с корректными данными")
    public void shouldAuthorizeTest() {
        step("Заполнить поля логина и пароля и нажать кнопку авторизации", () -> {
            mainPage.mainInputLog
                    .sendKeys("alex156qa");
            mainPage.mainInputPass
                    .sendKeys("123");
        });
        step("Проверить, что аккаунт авторизовался", () -> {
            mainPage.mainAuthorButton
                    .click();
            mainPage.mainLogoAccount
                    .click();
            mainPage.mainYourProfile
                    .click();
            mainPage.mainYourNickname
                    .shouldHave(text("Alex156qa"));
        });
    }

    @MethodSource("incorrectCredentials")
    @Story("Авторизация неуспешная")
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("Авторизация с некорректными данными:")
    public void shouldNotAuthorizeTest(String type, String phone, String password) {
        step("Заполнить поля логина и пароля и нажать кнопку авторизации", () -> {
            mainPage.mainInputLog
                    .sendKeys(phone);
            mainPage.mainInputPass
                    .sendKeys(password);
            mainPage.mainAuthorButton
                    .click();
        });
        step("Проверить, что отобразилась ошибка", () -> {
            mainPage.mainErrorAuthor
                    .shouldBe(visible);
        });
    }

    static Stream<Arguments> incorrectCredentials() {
        return Stream.of(
                arguments(
                        "зарегистрированный номер телефона и пароль от чужого аккаунта",
                        "9999999999",
                        "123456789Qq"

                ),
                arguments(
                        "незарегистрированный номер телефона и пароль от чужого аккаунта",
                        "9100000000",
                        "123456789Qq"
                )
        );
    }
}
