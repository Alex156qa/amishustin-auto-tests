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
    public SelenideElement mainSearchWWInput =  $(".AppHeader-searchButton.form-control.input-contrast");
    public SelenideElement mainLinkBranches =  $(".file-navigation.mb-3.d-flex.flex-items-start .ml-3.Link--primary.no-underline .octicon.octicon-git-branch");
    public SelenideElement mainBranchesFixtures =  $("[branch=\"fixtures\"] .branch-name.css-truncate-target.v-align-baseline.width-fit.mr-2.Details-content--shown");
    public SelenideElement mainDropDownFixtures =  $(".btn.css-truncate");
    public SelenideElement mainSearchInput =  $("#qb-input-query");
    public SelenideElement mainSearchIncognito =  $("[data-target=\"qbsearch-input.inputButtonText\"]");
    public SelenideElement mainSearchTextInput =  $("#query-builder-test");
    public SelenideElement mainAuthSingIn =  $(".HeaderMenu-link.HeaderMenu-link--sign-in.flex-shrink-0.no-underline.d-block.d-lg-inline-block.border.border-lg-0.rounded.rounded-lg-0.p-2.p-lg-0");
    public SelenideElement mainBlokRelease =  $("[data-testid=\"results-list\"]");
    public SelenideElement mainSearchOpen =  $("#query-builder-test");



    public void click() {
    }
}
