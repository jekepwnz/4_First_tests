import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v131.filesystem.model.File;

public class PracticeFormFill {

    @Test
    void formFill() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Eugene");
        $("#lastName").setValue("Park");
        $("#userEmail").setValue("egp@gmail.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("9998791234");
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").click();
        $(byText("March")).click();
        $(".react-datepicker__year-select").$(byText("1990")).click();
        $(".react-datepicker__month").$(byText("7")).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Histo");
        $("#react-select-2-option-0").click();
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-3").parent().click();
        $("#uploadPicture").uploadFromClasspath("exmaple_file.png");
        $("#currentAddress").setValue("Hello! its my address here :)");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Gurgaon")).click();
        $("#submit").click();

        //todo assertions

    }
}
