import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EnterprisePageCheck {

    @Test
    void enterprisePageAvailable() {
        open("https://github.com/");
        $(".HeaderMenu-nav").$("ul").$(byText(("Solutions"))).hover();
        $(byText("By company size")).parent().$(byText("Enterprises")).click();
        $("[data-testid=SubNav-root-heading]").shouldHave(text("Enterprise"));
    }
}
