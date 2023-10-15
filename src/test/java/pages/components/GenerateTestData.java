package pages.components;

import com.github.javafaker.Faker;
import org.w3c.dom.ls.LSOutput;

import java.util.Locale;

public class GenerateTestData {
    Faker faker = new Faker(new Locale("en-GB"));

    public String fakeSubject;
    public void generateFakeSubject() {
    String [] subjects = {"Maths", "English", "Chemistry", "Computer science", "Commerce", "Economics" };
    int n = (int)Math.floor(Math.random() * subjects.length);
    fakeSubject = (subjects[n]);

   }






    public String
     fakeFirstName = faker.name().firstName(),
     fakeLastName = faker.name().lastName(),
     fakeUserEmail = faker.internet().emailAddress(),
     fakeStreetAddress = faker.address().streetAddress(),
     fakeUserNumber = faker.phoneNumber().subscriberNumber(10);



    public Integer
     fakeDayOfBirth = faker.number().numberBetween(10,28),
     fakeYearOfBirth = faker.date().birthday().getYear();




}
