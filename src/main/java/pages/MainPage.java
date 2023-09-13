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
    public SelenideElement mainSearchInput =  $(".AppHeader-searchButton.form-control.input-contrast");
    public SelenideElement mainLinkBranches =  $(".file-navigation.mb-3.d-flex.flex-items-start .ml-3.Link--primary.no-underline .octicon.octicon-git-branch");
    public SelenideElement mainBranchesFixtures =  $("[branch=\"fixtures\"] .branch-name.css-truncate-target.v-align-baseline.width-fit.mr-2.Details-content--shown");
    public SelenideElement mainDropDownFixtures =  $(".btn.css-truncate");


    public void click() {
    }
}
