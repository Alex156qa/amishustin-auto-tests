import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static pages.TestPages.mainPage;

public class SearchTests {

    @Test
    @DisplayName("Переключение на ветку fixtures")
    public void shouldSwitchBranches() {
        open("https://github.com/junit-team/junit4");
        mainPage.mainLinkBranches
                        .click();
        mainPage.mainBranchesFixtures
                        .click();
        mainPage.mainDropDownFixtures
                .shouldHave(text("Fixtures"));
        sleep(2000);
    }

    @Test
    @DisplayName("Позитивные проверки поиска по релизам ")
    public void searshTestReleases() {
        open("https://github.com/junit-team/junit4");
        mainPage.mainAuthSingIn.click();
        mainPage.mainInputLog
                .sendKeys("alex156qa");
        mainPage.mainInputPass
                .sendKeys("Sasha!kazan156");
        mainPage.mainAuthorButton
                .click();
        mainPage.mainSearchIncognito
                .click();
        mainPage.mainSearchTextInput
                .sendKeys("4.9.");
        mainPage.mainSearchTextInput
                .pressEnter();
        mainPage.mainBlokRelease
                        .shouldHave(text("doc/ReleaseNotes4.9.md"));
        mainPage.mainSearchInput
                        .click();
        mainPage.mainSearchTextInput
                .sendKeys("Summary of Changes in version 4.9, final");
        mainPage.mainSearchTextInput
                .pressEnter();
        mainPage.mainBlokRelease
                .shouldHave(text("## Summary of Changes in version 4.9, final ##\n" +
                        "Release theme: Test-class and suite level Rules."));
        sleep(2000);



    }
}
