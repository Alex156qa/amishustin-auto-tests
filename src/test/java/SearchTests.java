import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static pages.TestPages.mainPage;

public class SearchTests {
    @Owner("Alex156qa")
    @BeforeEach
    public void setup() {
        open("https://github.com/junit-team/junit4");
    }

    @Test
    @Story("Переключение ветки")
    @DisplayName("Переключение на ветку fixtures")
    public void shouldSwitchBranches() {
        step("Выбрать ветку Fixtures", () -> {
        mainPage.mainLinkBranches
                .click();
        mainPage.mainBranchesFixtures
                .click();
        });
        step("Проверить, что мы переключились на ветку Fixtures", () -> {
        mainPage.mainDropDownFixtures
                .shouldHave(text("Fixtures"));
    });
    }

    @Test
    @Story("Поиск по элементам в релизе")
    @DisplayName("Позитивные проверки поиска по релизам ")
    public void searshTestReleases() {
        step("Проверка поиска по номеру релиза", () -> {
            mainPage.mainAuthSingIn.click();
            mainPage.mainInputLog
                    .sendKeys("alex156qa");
            mainPage.mainInputPass
                    .sendKeys("123");
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
        });
        step("Проверка поиска по строчкам из релиза", () -> {
            mainPage.mainSearchInput
                    .click();
            mainPage.mainButtonSearchOff
                    .click();
            mainPage.mainSearchTextInput
                    .sendKeys("repo:junit-team/junit4 Summary of Changes in version 4.9, final");
            mainPage.mainSearchTextInput
                    .pressEnter();
            mainPage.mainBlokRelease
                    .shouldHave(text("## Summary of Changes in version 4.9, final ##"));
        });
        step("Проверка поиска по названию релиза", () -> {
            mainPage.mainSearchInput
                    .click();
            mainPage.mainButtonSearchOff
                    .click();
            mainPage.mainSearchTextInput
                    .sendKeys("repo:junit-team/junit4 doc/ReleaseNotes4.8.1.md");
            mainPage.mainSearchTextInput
                    .pressEnter();
            mainPage.mainBlokRelease
                    .shouldHave(text("doc/ReleaseNotes4.8.1.md"));
        });
    }
}
