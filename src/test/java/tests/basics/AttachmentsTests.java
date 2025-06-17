package tests.basics;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTests {

    @Test
    void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        //arranges
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1280x1024";


        //variables for test
        String name = "Eugene";
        String lastName = "Park";
        String email = "egp@gmail.com";
        String gender = "Male";
        String number = "9998791234";
        String dateOfBirth = "25 March,1990";
        String[] hobbys = new String[2];
        hobbys[0] = "Sports";
        hobbys[1] = "Music";
        String picture = "example_file.png";
        String state = "NCR";
        String city = "Gurgaon";
        String address = "Hello! its my address here :)";
        String subject = "History";

        //actions

        step("Открываем страницу с формой для заполнения", () -> {
            open("https://demoqa.com/automation-practice-form");
            attachment("Source", webdriver().driver().source());
        });

    }

    @Test
    public void testAnnotatedAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.pageLoadStrategy = "eager";
        WebSteps steps = new WebSteps();

        steps.openFormPage();
        steps.takeScreenshot();

    }
}
