import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static pages.TestPages.mainPage;

public class AuthTest {

    @BeforeEach
    public void setup() {
        open("https://github.com/");
        mainPage.mainSignInButton.click();
    }

    @Test
    @DisplayName("Успешная авторизация")
    public void shouldAuthorizeTest() {
       mainPage.mainInputLog
                .sendKeys("alex156qa");
       mainPage.mainInputPass
               .sendKeys("123");
      mainPage.mainAuthorButton
               .click();
        mainPage.mainLogoAccount
                .click();
        mainPage.mainYourProfile
                .click();
        mainPage.mainYourNickname
                .shouldHave(text("Alex156qa"));
    }
    @MethodSource("incorrectCredentials")
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("Авторизация с некорректными данными:")
    public void shouldNotAuthorizeTest(String type, String phone, String password){
       mainPage.mainInputLog
                .sendKeys(phone);
        mainPage.mainInputPass
                .sendKeys(password);
        mainPage.mainAuthorButton
                .click();
        mainPage.mainErrorAuthor
                .shouldBe(visible);
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
