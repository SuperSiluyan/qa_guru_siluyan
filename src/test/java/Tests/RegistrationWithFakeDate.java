

import Pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import Tests.TestBase;

import java.util.Locale;


public class RegistrationWithFakeDate extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillTestForm() {

        Faker faker = new Faker(new Locale("en-GB"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String streetAddress = faker.address().streetAddress();
        String userNumber = faker.phoneNumber().subscriberNumber(10);
        Integer dayOfBirth = faker.number().numberBetween(01,28);


        // Заполнение формы
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Male")
                .setUserNumber(userNumber)
                .setDateOfBirthWithFaker(dayOfBirth, "March", "1991")
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
