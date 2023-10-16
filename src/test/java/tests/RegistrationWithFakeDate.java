package tests;

import pages.components.GenerateTestData;
import pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import tests.TestBase;


public class RegistrationWithFakeDate extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    GenerateTestData generateTestData = new GenerateTestData();


    @Test
    void fillTestForm() {

        generateTestData.generateRandomSubject();
        generateTestData.generateRandomMonth();
        generateTestData.generateRandomGender();
        generateTestData.generateRandomState();
        generateTestData.generateRandomCity();


        // Заполнение формы
        registrationPage.openPage()
                .setFirstName(generateTestData.fakeFirstName)
                .setLastName(generateTestData.fakeLastName)
                .setEmail(generateTestData.fakeUserEmail)
                .setGender(generateTestData.randomGender)
                .setUserNumber(generateTestData.fakeUserNumber)
                .setDateOfBirth(generateTestData.fakeDayOfBirth, generateTestData.randomMonth, generateTestData.fakeYearOfBirth)
                .setSubjectValue(generateTestData.randomSubject)
                .subjectClick()
                .hobbiesClick()
                .uploadPicture("b.jpg")
                .setAddress(generateTestData.fakeStreetAddress)
                .setState(generateTestData.randomState)
                .setCity(generateTestData.randomCity)
                .clickSubmit();


        //Проверка контента

        registrationPage.checkResult("Student Name", generateTestData.fakeFirstName + ' ' + generateTestData.fakeLastName)
                .checkResult("Student Email", generateTestData.fakeUserEmail)
                .checkResult("Mobile", generateTestData.fakeUserNumber)
                .checkResult("Gender", generateTestData.randomGender)
                .checkResult("Date of Birth", generateTestData.fakeDayOfBirth + " " + generateTestData.randomMonth + ',' + "19" + generateTestData.fakeYearOfBirth)
                .checkResult("Subjects", generateTestData.randomSubject)
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "b.jpg")
                .checkResult("Address", generateTestData.fakeStreetAddress)
                .checkResult("State and City", generateTestData.randomState + " " + generateTestData.randomCity);
    }


}
