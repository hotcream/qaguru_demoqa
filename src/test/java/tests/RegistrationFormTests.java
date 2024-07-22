package tests;

import jdk.jfr.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

import java.util.Map;

import static enums.ResultTableEnums.*;

@Tag("regression")
@DisplayName("Registration form tests")
public class RegistrationFormTests extends BaseTest {

    TestData testData = new TestData();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("smoke")
    @DisplayName("Check the registration form with all fields filled in")
    void checkRegistrationFormAllFieldsTest() {
        registrationPage.openPage()
                .removeBannerAndFooter()
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
    @DisplayName("Check the registration form for required fields")
    void checkRegistrationFormRequiredFieldsTest() {
        registrationPage.openPage()
                .removeBannerAndFooter()
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
    @Tag("negative")
    @DisplayName("Check the Registration Form Without the Last Name")
    void checkRegistrationFormWithoutLastNameTest() {
        registrationPage.openPage()
                .removeBannerAndFooter()
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