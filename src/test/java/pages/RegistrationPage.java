package pages;

import pages.components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    ///// SelenideElements
    CalendarComponent calendar = new CalendarComponent();
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            subjectSelect = $("#react-select-2-option-0"),
            hobbiesSports = $("[for=hobbies-checkbox-1]"),
            imageInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            selectStateDropdown = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            selectCityDropdown = $("#city"),
            submitButton = $("#submit");


    ///// Actions
    public RegistrationPage openPage() {
        open("automation-practice-form");


        return this;
    }

    public RegistrationPage hideBanner() {

        executeJavaScript("$('#fixedban').remove()");
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

    public RegistrationPage setDateOfBirth(int day, String month, int year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }


    public RegistrationPage setSubjectValue(String value) {
        subjectInput.setValue(value);

        return this;
    }

    public RegistrationPage subjectClick() {
        subjectSelect.click();

        return this;
    }

    public RegistrationPage hobbiesClick() {
        hobbiesSports.click();

        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        imageInput.uploadFromClasspath(fileName);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String state) {
        selectStateDropdown.click();
        stateCityWrapper.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        selectCityDropdown.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

}
