package guru.qa;

import guru.qa.pages.GitHubSearchPage;
import io.qameta.allure.Step;

import static guru.qa.TestData.searchQuery;

public class WebSteps extends TestBase {

    GitHubSearchPage gitHubSearchPage = new GitHubSearchPage();

    @Step("Open Main Page")
    public void openMainPage() {
        gitHubSearchPage
                .openPage();
    }

    @Step("Search for repository")
    public void searchForRepository() {
        gitHubSearchPage
                .tapSearchBox()
                .inputSearchQuery(searchQuery)
                .pressEnter();
    }

    @Step("Click search result link")
    public void clickOnRepositoryLink() {
        gitHubSearchPage
                .clickSearchQuery();
    }
    @Step("Open Issues Tab")
    public void openIssuesTab() {
        gitHubSearchPage
                .openIssuesTab();
    }

    @Step("Verify that the issue is present in the list")
    public void verifyIssueInList() {
        gitHubSearchPage
                .checkIssuePresentInList();
    }
}
