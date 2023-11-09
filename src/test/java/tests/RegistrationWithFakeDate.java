package tests;

import pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import testBases.TestBase;


public class RegistrationWithFakeDate extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void fillTestForm() {

        // Заполнение формы
        registrationPage.openPage()
                .setFirstName(testData.fakeFirstName)
                .setLastName(testData.fakeLastName)
                .setEmail(testData.fakeUserEmail)
                .setGender(testData.randomGender)
                .setUserNumber(testData.fakeUserNumber)
                .setDateOfBirth(testData.fakeDayOfBirth, testData.randomMonth, testData.fakeYearOfBirth)
                .setSubjectValue(testData.randomSubject)
                .subjectClick()
                .hobbiesClick()
                .uploadPicture("b.jpg")
                .setAddress(testData.fakeStreetAddress)
                .setState(testData.randomState)
                .setCity(testData.randomCity)
                .clickSubmit();

        //Проверка контента
        registrationPage.checkResult("Student Name", testData.fakeFirstName + ' ' + testData.fakeLastName)
                .checkResult("Student Email", testData.fakeUserEmail)
                .checkResult("Mobile", testData.fakeUserNumber)
                .checkResult("Gender", testData.randomGender)
                .checkResult("Date of Birth", testData.fakeDayOfBirth + " " + testData.randomMonth + ',' + "19" + testData.fakeYearOfBirth)
                .checkResult("Subjects", testData.randomSubject)
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "b.jpg")
                .checkResult("Address", testData.fakeStreetAddress)
                .checkResult("State and City", testData.randomState + " " + testData.randomCity);
    }
}