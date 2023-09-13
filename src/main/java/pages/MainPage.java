package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public SelenideElement mainSignInButton =  $("[href='/login']");
    public SelenideElement mainInputLog = $("[id='login_field']");

    public SelenideElement mainInputPass = $("[id='password']");
    public SelenideElement mainAuthorButton =  $(".js-sign-in-button");
    public SelenideElement mainLogoAccount =  $(".Button--invisible-noVisuals");
    public SelenideElement mainYourProfile =  $(byText("Your profile"));
    public SelenideElement mainYourNickname =  $(".p-nickname");
    public SelenideElement mainErrorAuthor =  $(".flash.flash-full.flash-error");


    public void click() {
    }
}
