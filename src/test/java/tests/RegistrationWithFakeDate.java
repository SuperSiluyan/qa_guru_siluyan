

import pages.components.GenerateTestData;
import pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import tests.TestBase;


public class RegistrationWithFakeDate extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    GenerateTestData generateTestData = new GenerateTestData();


    @Test
    void fillTestForm() {

        generateTestData.generateFakeSubject();


        // Заполнение формы
        registrationPage.openPage()
                .setFirstName(generateTestData.fakeFirstName)
                .setLastName(generateTestData.fakeLastName)
                .setEmail(generateTestData.fakeUserEmail)
                .setGender("Male")
                .setUserNumber(generateTestData.fakeUserNumber)
                .setDateOfBirthWithFaker(generateTestData.fakeDayOfBirth, "March", generateTestData.fakeYearOfBirth)
                .setSubjectValue(generateTestData.fakeSubject)
                .subjectClick()
                .hobbiesClick()
                .uploadPicture("b.jpg")
                .setAddress(generateTestData.fakeStreetAddress)
                .setStateNCR()
                .setCityDelhi()
                .clickSubmit();


        //Проверка контента

        registrationPage.checkResult("Student Name", generateTestData.fakeFirstName + ' ' + generateTestData.fakeLastName)
                .checkResult("Student Email", generateTestData.fakeUserEmail)
                .checkResult("Mobile", generateTestData.fakeUserNumber)
                .checkResult("Gender", "Male")
                .checkResult("Date of Birth", generateTestData.fakeDayOfBirth + " March" + ',' + "19" + generateTestData.fakeYearOfBirth)
                .checkResult("Subjects", generateTestData.fakeSubject)
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "b.jpg")
                .checkResult("Address", generateTestData.fakeStreetAddress)
                .checkResult("State and City", "NCR Delhi");
    }


}
