package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GitHubSearchPage {

    SelenideElement
            searchBox = $("[placeholder='Search or jump to...']"),
    queryBuilder = $("#query-builder-test"),
            searchResult = $(linkText("junit-team/junit5")),
            issuesTab = $("#issues-tab"),
            issueNumber = $("#issue_3376");

    public GitHubSearchPage openPage() {
        open("https://github.com/");

        return this;
    }

    public GitHubSearchPage tapSearchBox() {
        searchBox.click();

        return this;
    }

    public GitHubSearchPage inputSearchQuery(String value) {
//        searchBox.setValue(value);
        queryBuilder.setValue(value);

        return this;
    }

    public GitHubSearchPage pressEnter() {
        queryBuilder.pressEnter();

        return this;
    }

    public GitHubSearchPage clickSearchQuery() {
        searchResult.click();

        return this;
    }

    public GitHubSearchPage openIssuesTab() {
        issuesTab.click();

        return this;
    }

    public GitHubSearchPage checkIssuePresentInList() {
        issueNumber.should(exist);

        return this;
    }
}
