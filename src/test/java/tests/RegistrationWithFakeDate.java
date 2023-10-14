

import pages.components.GenerateTestData;
import pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import tests.TestBase;


public class RegistrationWithFakeDate extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    GenerateTestData generateTestData = new GenerateTestData();

    @Test
    void fillTestForm() {




        // Заполнение формы
        registrationPage.openPage()
                .setFirstName(generateTestData.firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Male")
                .setUserNumber(userNumber)
                .setDateOfBirthWithFaker(dayOfBirth, "March", yearOfBirth)
                .setSubjectValue("Maths")
                .subjectClick()
                .hobbiesClick()
                .uploadPicture("b.jpg")
                .setAddress(streetAddress)
                .setStateNCR()
                .setCityDelhi()
                .clickSubmit();


        //Проверка контента

        registrationPage.checkResult("Student Name", firstName + ' ' + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Mobile", userNumber)
                .checkResult("Gender", "Male")
                .checkResult("Date of Birth", dayOfBirth + " March,1991")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "b.jpg")
                .checkResult("Address", streetAddress)
                .checkResult("State and City", "NCR Delhi");
    }


}
