import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormFill {

    @Test
    void formFill() {

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
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(number);

        $(".react-datepicker__input-container").scrollIntoView(true).click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(text("25")).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        for (int i = 0; i < 2; i++) {
            $("#hobbiesWrapper").$(byText(hobbys[i])).hover().click();
        }

        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();

        //asserts
        $("div.modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(byText("Student Name")).sibling(0).shouldHave(text(name), text(lastName));
        $(byText("Student Email")).sibling(0).shouldHave(text(email));
        $(byText("Gender")).sibling(0).scrollIntoView(true).shouldHave(text(gender));
        $(".modal-body").$(byText("Mobile")).sibling(0).shouldHave(text(number));
        $(".modal-body").$(byText("Date of Birth")).sibling(0).shouldHave(text(dateOfBirth));

        for (int i = 0; i < 1; i++) {
            $(".modal-body").$(byText("Hobbies")).sibling(i).shouldHave(text(hobbys[i]));
        }
        $(".modal-body").$(byText("Picture")).sibling(0).shouldHave(text(picture));
        $(".modal-body").$(byText("Address")).sibling(0).shouldHave(text(address));
        $(".modal-body").$(byText("State and City")).sibling(0)
                .shouldHave(text(state), text(city));

    }
}
