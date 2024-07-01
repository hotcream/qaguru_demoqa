package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void checkRegistrationFormAllFields() {
        registrationPage.openPage()
                .setFirstName("Henri")
                .setLastName("Chinaski")
                .setEmail("test@gmail.pu")
                .setGender("Male")
                .setUserNumber("9998887776")
                .setDateOfBirth("10", "October", "1991")
                .setSubject("Physics")
                .scrollToSubmitButton()
                .setHobbies("Sports")
                .setCurrentAddress("Bangkok")
                .setState("NCR")
                .setCity("Delhi")
                .uploadPicture("hi.jpg")
                .clickSubmitButton()
                .checkResultTitle("Thanks for submitting the form")
                .checkResultTable("Student Name", "Henri Chinaski")
                .checkResultTable("Student Email", "test@gmail.pu")
                .checkResultTable("Gender", "Male")
                .checkResultTable("Mobile", "9998887776")
                .checkResultTable("Date of Birth", "10 October,1991")
                .checkResultTable("Subjects", "Physics")
                .checkResultTable("Picture", "hi.jpg")
                .checkResultTable("Address", "Bangkok")
                .checkResultTable("State and City", "NCR Delhi");
    }

    @Test
    void checkRegistrationFormRequiredFields() {
        registrationPage.openPage()
                .setFirstName("Henri")
                .setLastName("Chinaski")
                .setEmail("test@gmail.pu")
                .setGender("Male")
                .setUserNumber("9998887776")
                .setDateOfBirth("10", "October", "1991")
                .clickSubmitButton()
                .checkResultTable("Student Name", "Henri Chinaski")
                .checkResultTable("Student Email", "test@gmail.pu")
                .checkResultTable("Gender", "Male")
                .checkResultTable("Mobile", "9998887776")
                .checkResultTable("Date of Birth", "10 October,1991")
                .checkResultTitle("Thanks for submitting the form");
    }

    @Test
    void checkRegistrationFormWithoutLastName() {
        registrationPage.openPage()
                .setFirstName("Henri")
                .setEmail("test@gmail.pu")
                .setGender("Male")
                .setUserNumber("9998887776")
                .setDateOfBirth("10", "October", "1991")
                .setSubject("Physics")
                .scrollToSubmitButton()
                .setHobbies("Sports")
                .setCurrentAddress("Bangkok")
                .setState("NCR")
                .setCity("Delhi")
                .uploadPicture("hi.jpg")
                .clickSubmitButton()
                .checkTitleMissing();
    }
}