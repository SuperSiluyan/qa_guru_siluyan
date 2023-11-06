package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.GenerateTestData.*;

public class TestData {

    Faker faker = new Faker(new Locale("en-GB"));

    public String
            fakeFirstName = faker.name().firstName(),
            fakeLastName = faker.name().lastName(),
            fakeUserEmail = faker.internet().emailAddress(),
            fakeStreetAddress = faker.address().streetAddress(),
            fakeUserNumber = faker.phoneNumber().subscriberNumber(10);

    public int
            fakeDayOfBirth = faker.number().numberBetween(10, 28),
            fakeYearOfBirth = faker.number().numberBetween(10, 99);


    public String randomSubject = generateRandomSubject();
    public String randomMonth = generateRandomMonth();
    public String randomState = generateRandomState();
    public String randomCity = generateRandomCity(randomState);
    public String randomGender = generateRandomGender();

}
