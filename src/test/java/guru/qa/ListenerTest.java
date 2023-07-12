package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.GitHubSearchPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static guru.qa.TestData.searchQuery;

public class ListenerTest extends TestBase {

    GitHubSearchPage gitHubSearchPage = new GitHubSearchPage();

    @Test
    public void issueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        gitHubSearchPage
                .openPage()
                .tapSearchBox()
                .inputSearchQuery(searchQuery)
                .pressEnter()
                .clickSearchQuery()
                .openIssuesTab()
                .checkIssuePresentInList();
    }
}
