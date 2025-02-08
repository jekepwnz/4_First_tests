package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWiki {

    @Test
    void wikiCheck() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body ul").$(byText("Soft assertions")).shouldBe(Condition.exist);
        $(".markdown-body ul").$(byText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("junit5"));

    }
}
