import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BestContributorToSelenide {
    @Test
    void bestContributor(){

//        Configuration.pageLoadStrategy = "eager";

        open("https://github.com/selenide/selenide");
        $("div.Layout-sidebar").$(byText("Contributors"))
                .closest(".BorderGrid-cell").$$("ul li").first().hover();
//                .closest("h2").sibling(0).$$("li").first().hover(); // второй вариант через соседей
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));



    }
}
