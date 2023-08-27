import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthTest {

    @Test
    public void shouldAuthorizeTest() {
       open("https://github.com/");
       $("[href='/login']").click();
        $("[id='login_field']").sendKeys("alex156qa");
       $("[id='password']").sendKeys("123");
       $(".js-sign-in-button").click();
        $(".Button--invisible-noVisuals").click();
        $(byText("Your profile")).click();
        $(".p-nickname").shouldHave(text("Alex156qa"));
    }

}
