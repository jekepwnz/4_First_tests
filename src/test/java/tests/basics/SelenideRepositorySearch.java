package tests.basics;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositorySearch {

    @BeforeAll
    static void configureBrowser() {
//        Configuration.pageLoadStrategy = "eager";
//        Configuration.browserSize = "1920x1080";
    }

    @Test
    void SelenideRepositorySearch() {

        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click();
        $("[name=query-builder-test]").setValue("Selenide").pressEnter();
        $$("div[data-testid=results-list]").first().$("a").click();
        sleep(3000);
        $("[id=repository-container-header]").shouldHave(text("selenide / selenide"));

    }
}
