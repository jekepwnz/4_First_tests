package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormWithPageObjects extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void succecfullRegistrationTest() {

        //variables for test
        String name = "Eugene";
        String lastName = "Park";
        String email = "egp@gmail.com";
        String gender = "Male";
        String number = "9998791234";
        String birthDay = "25";
        String birthMonth = "March";
        String birthYear = "1990";
        String[] hobbies = new String[2];
        hobbies[0] = "Sports";
        hobbies[1] = "Music";
        String picture = "example_file.png";
        String state = "NCR";
        String city = "Gurgaon";
        String address = "Hello! its my address here :)";
        String subject = "History";

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
