package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

import java.util.Map;

import static enums.ResultTableEnums.*;

public class RegistrationFormTests extends BaseTest {

    TestData testData = new TestData();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void checkRegistrationFormAllFields() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.mobilePhone)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .scrollToSubmitButton()
                .setHobbies(testData.hobbies)
                .setCurrentAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .uploadPicture(testData.uploadFile)
                .clickSubmitButton()
                .checkResultTitle()
                .checkResultTable(Map.of(
                        STUDENT_NAME, testData.firstName + " " + testData.lastName,
                        STUDENT_EMAIL, testData.email,
                        GENDER, testData.gender,
                        MOBILE, testData.mobilePhone,
                        DATE_OF_BIRTH, testData.day + " " + testData.month + "," + testData.year,
                        SUBJECTS, testData.subject,
                        ADDRESS, testData.address,
                        PICTURE, testData.uploadFile,
                        STATE_AND_CITY, testData.state + " " + testData.city)
                );
    }

    @Test
    void checkRegistrationFormRequiredFields() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.mobilePhone)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .clickSubmitButton()
                .checkResultTitle()
                .checkResultTable(Map.of(
                        STUDENT_NAME, testData.firstName + " " + testData.lastName,
                        STUDENT_EMAIL, testData.email,
                        GENDER, testData.gender,
                        MOBILE, testData.mobilePhone,
                        DATE_OF_BIRTH, testData.day + " " + testData.month + "," + testData.year)
                );
    }

    @Test
    void checkRegistrationFormWithoutLastName() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.mobilePhone)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .scrollToSubmitButton()
                .setHobbies(testData.hobbies)
                .setCurrentAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .uploadPicture(testData.uploadFile)
                .clickSubmitButton()
                .checkTitleMissing();
    }
}