package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();// todo move to selenide elements

        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value); // todo move to selenide elements

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $(".react-datepicker__input-container").scrollIntoView(true).click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter(); // todo move to selenide elements

        return this;
    }

    public RegistrationPage setHobbies(String[] hobbies) {
        for (String hobby : hobbies) {
            $("#hobbiesWrapper").$(byText(hobby)).hover().click();
        }
        return this;
    }

    public RegistrationPage uploadPicture(String picture) {
        $("#uploadPicture").uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public RegistrationPage setCityAndState(String state, String city) {
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        return this;
    }

    public RegistrationPage pressSubmit() {
        $("#submit").click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}
