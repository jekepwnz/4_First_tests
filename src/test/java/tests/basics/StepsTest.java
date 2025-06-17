package tests.basics;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    @Test
    void testLambdaStep() {
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
        });

        step("Удаляем футер с помощью JS скрипта", () ->{
            executeJavaScript("$('footer').remove()");

        });
        step("Заполняем форму", () -> {
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
        });

        step("Нажимаем кнопку отправить", () -> {
            $("#submit").click();
        });

        step("Проверяем данные в модальном окне", () -> {
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
        });

        //asserts


    }

    @Test
    public void testAnnotatedStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.pageLoadStrategy = "eager";
        WebSteps steps = new WebSteps();

        steps.openFormPage();
        steps.deleteFooter();
        steps.fillForm();
        steps.clickSubmitButton();
        steps.checkData();
    }
}
