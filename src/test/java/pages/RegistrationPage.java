package pages;

import com.codeborne.selenide.SelenideElement;
import enums.ResultTableEnums;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.JavascriptHelper.removeBannerAndFooter;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            submitButton = $("#submit"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            uploadPicture = $("#uploadPicture"),
            studentRegistrationFormTitle = $(".practice-form-wrapper");
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        removeBannerAndFooter();
        studentRegistrationFormTitle.shouldHave(text("Student Registration Form"));
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
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage scrollToSubmitButton() {
        submitButton.scrollTo();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResultTable(ResultTableEnums key, String value) {
        resultTableComponent.checkTable(key,value);
        return this;
    }

    public RegistrationPage checkResultTable(Map<ResultTableEnums, String> results) {
        results.forEach((key, value) -> resultTableComponent.checkTable(key, value));
        return this;
    }

    public RegistrationPage checkResultTitle() {
        resultTableComponent.checkTitle();
        return this;
    }

    public RegistrationPage checkTitleMissing() {
        resultTableComponent.checkTitleMissing() ;
        return this;
    }
}