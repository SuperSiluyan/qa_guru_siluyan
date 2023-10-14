package pages.components;

import com.github.javafaker.Faker;

import java.util.Locale;

public class GenerateTestData {
    Faker faker = new Faker(new Locale("en-GB"));


    public String
     fakeFirstName = faker.name().firstName(),
     fakeLastName = faker.name().lastName(),
     fakeUserEmail = faker.internet().emailAddress(),
     fakeStreetAddress = faker.address().streetAddress(),
     fakeUserNumber = faker.phoneNumber().subscriberNumber(10);
//    Integer dayOfBirth = faker.number().numberBetween(01,28),
//    Integer yearOfBirth = faker.number().numberBetween(1900,2100);



}
