package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

import static enums.ResultTableEnums.DATE_OF_BIRTH;
import static enums.ResultTableEnums.GENDER;
import static enums.ResultTableEnums.MOBILE;
import static enums.ResultTableEnums.PICTURE;
import static enums.ResultTableEnums.STUDENT_EMAIL;
import static enums.ResultTableEnums.STUDENT_NAME;
import static enums.ResultTableEnums.SUBJECTS;

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
                .checkResultTitle("Thanks for submitting the form")
                .checkResultTable(STUDENT_NAME , testData.firstName + " " + testData.lastName)
                .checkResultTable(STUDENT_EMAIL, testData.email)
                .checkResultTable(GENDER, testData.gender)
                .checkResultTable(MOBILE, testData.mobilePhone)
                .checkResultTable(DATE_OF_BIRTH, testData.day + " " + testData.month + "," + testData.year)
                .checkResultTable(SUBJECTS, testData.subject)
                .checkResultTable(PICTURE, testData.uploadFile)
                .checkResultTable(ADDRESS, testData.address)
                .checkResultTable("State and City", testData.state + " " + testData.city);
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
                .checkResultTitle("Thanks for submitting the form")
                .checkResultTable("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultTable("Student Email", testData.email)
                .checkResultTable("Gender", testData.gender)
                .checkResultTable("Mobile", testData.mobilePhone)
                .checkResultTable("Date of Birth", testData.day + " " + testData.month + "," + testData.year);
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