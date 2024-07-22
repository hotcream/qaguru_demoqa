package pages;

import com.codeborne.selenide.SelenideElement;
import enums.ResultTableEnums;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

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

    @Step("Open page /automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        studentRegistrationFormTitle.shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Remove banner and footer")
    public RegistrationPage removeBannerAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Set firstname")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Set lastname")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Set email")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Set gender")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Set user number")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Set date if birth")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Set subject")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Scroll to submit button")
    public RegistrationPage scrollToSubmitButton() {
        submitButton.scrollTo();
        return this;
    }

    @Step("Set hobbies")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Set current address")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("Set state")
    public RegistrationPage setState(String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Set city")
    public RegistrationPage setCity(String value) {
        city.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Upload picture")
    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Click submit button")
    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Check result table")
    public RegistrationPage checkResultTable(Map<ResultTableEnums, String> results) {
        results.forEach((key, value) -> resultTableComponent.checkTable(key, value));
        return this;
    }

    @Step("Check result title" )
    public RegistrationPage checkResultTitle() {
        resultTableComponent.checkTitle();
        return this;
    }

    @Step("Check title missing")
    public RegistrationPage checkTitleMissing() {
        resultTableComponent.checkTitleMissing() ;
        return this;
    }
}