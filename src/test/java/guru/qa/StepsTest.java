package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.GitHubSearchPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static guru.qa.TestData.issueNumber;
import static guru.qa.TestData.searchQuery;
import static io.qameta.allure.Allure.step;

public class StepsTest extends TestBase {

    GitHubSearchPage gitHubSearchPage = new GitHubSearchPage();

    @Test
    public void issueSearchLambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open Main Page", () -> {
            gitHubSearchPage
                    .openPage();
        });

        step("Search for" + " " + searchQuery, () -> {
            gitHubSearchPage
                    .tapSearchBox()
                    .inputSearchQuery(searchQuery)
                    .pressEnter();
        });

        step("Click search result link", () -> {
            gitHubSearchPage
                    .clickSearchQuery();
        });

        step("Open Issues Tab", () -> {
            gitHubSearchPage
                    .openIssuesTab();
        });

        step("Verify that the issue" + " " + issueNumber + " " + "is present in the list", () -> {
            gitHubSearchPage
                    .checkIssuePresentInList();
        });
    }

    @Test
    public void issueSearchAnnotatedTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository();
        steps.clickOnRepositoryLink();
        steps.openIssuesTab();
        steps.verifyIssueInList();
    }
}
