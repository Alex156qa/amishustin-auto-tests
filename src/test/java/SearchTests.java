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
}
