package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@DisplayName("Тесты на общую форму")
public class PracticeFormWithPageObjects extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Успешная регистрация")
    void succecfullRegistrationTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        //variables for test
        String name = "Eugene",
                lastName = "Park",
                email = "egp@gmail.com",
                gender = "Male",
                number = "9998791234",
                birthMonth = "March",
                birthDay = "25",
                birthYear = "1990",
                picture = "example_file.png",
                state = "NCR",
                city = "Gurgaon",
                address = "Hello! its my address here :)",
                subject = "History";
        String[] hobbies = {"Sports", "Music"};


        //actions
        registrationPage.openPage()
                .setFirstName(name)
                .setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(number)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setAddress(address)
                .setCityAndState(state, city)
                .pressSubmit();

        //asserts
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", name + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResult("Subjects", subject);
        for (String hobby : hobbies) {
            registrationPage.verifyResult("Hobbies", hobby);
        }
        registrationPage.verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

    }

}
