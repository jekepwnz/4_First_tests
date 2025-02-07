import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v131.filesystem.model.File;

import java.lang.reflect.Array;

public class PracticeFormFill {

    @Test
    void formFill() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        String name = "Eugene";
        String lastName = "Park";
        String email = "egp@gmail.com";
        String gender = "Male";
        String number = "9998791234";
        String dateOfBirth = "07 March,1990";
        String[] hobbys = new String[2];
        hobbys[0] = "Sports";
        hobbys[1] = "Music";
        String picture = "example_file.png";
        String state = "NCR";
        String city = "Gurgaon";
        String address = "Hello! its my address here :)";
        String subject = "History";




        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue(number);
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").click();
        $(byText("March")).click();
        $(".react-datepicker__year-select").$(byText("1990")).click();
        $(".react-datepicker__month").$(byText("7")).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue(subject);
        $("#react-select-2-option-0").click();
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-3").parent().click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();

        //todo assertions
        $(byText("Student Name")).sibling(0).shouldHave(text(name), text(lastName));
        $(byText("Student Email")).sibling(0).shouldHave(text(email));
        $(byText("Gender")).sibling(0).shouldHave(text(gender));
        $(".modal-body").$(byText("Mobile")).sibling(0).shouldHave(text(number));
        $(".modal-body").$(byText("Date of Birth")).sibling(0).shouldHave(text(dateOfBirth));

        for(int i = 0; i < 1; i ++){
            $(".modal-body").$(byText("Hobbies")).sibling(i).shouldHave(text(hobbys[i]));
        }
        $(".modal-body").$(byText("Picture")).sibling(0).shouldHave(text(picture));
        $(".modal-body").$(byText("Address")).sibling(0).shouldHave(text(address));
        $(".modal-body").$(byText("State and City")).sibling(0)
                .shouldHave(text(state), text(city));

    }
}
