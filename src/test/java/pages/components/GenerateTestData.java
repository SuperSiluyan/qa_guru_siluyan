package pages.components;

import com.github.javafaker.Faker;

import java.util.Locale;

public class GenerateTestData {
    Faker faker = new Faker(new Locale("en-GB"));

    public String randomSubject;

    public void generateRandomSubject() {
        String[] subjects = {"Maths", "English", "Chemistry", "Computer science", "Commerce", "Economics"};
        int n = faker.number().numberBetween(0, subjects.length);
        randomSubject = (subjects[n]);
    }


    public String randomMonth;

    public void generateRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November"};
        int n = faker.number().numberBetween(0, months.length);
        randomMonth = (months[n]);

    }



    public String randomGender;

    public void generateRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        int n = faker.number().numberBetween(0, genders.length);
        randomGender = (genders[n]);
    }

    public String randomState;

    public void generateRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int n = faker.number().numberBetween(0, states.length);
        randomState = (states[n]);
    }


    public String randomCity;

    public void generateRandomCity() {
        String[] ncrCity = {"Delhi", "Gurgaon", "Noida"};
        String[] uttarPradeshCity = {"Agra", "Lucknow", "Merrut"};
        String[] haryanaCity = {"Karnal", "Panipat"};
        String[] rajasthanCity = {"Jaipur", "Jaiselmer"};

        if (randomState.equals("NCR")) {
            randomCity = faker.options().option(ncrCity);
        } else if (randomState.equals("Uttar Pradesh")) {
            randomCity = faker.options().option(uttarPradeshCity);
        } else if (randomState.equals("Haryana")) {
            randomCity = faker.options().option(haryanaCity);
        } else if (randomState.equals("Rajasthan")) {
            randomCity = faker.options().option(rajasthanCity);
        }

    }


    public String
            fakeFirstName = faker.name().firstName(),
            fakeLastName = faker.name().lastName(),
            fakeUserEmail = faker.internet().emailAddress(),
            fakeStreetAddress = faker.address().streetAddress(),
            fakeUserNumber = faker.phoneNumber().subscriberNumber(10);


    public int
            fakeDayOfBirth = faker.number().numberBetween(10, 28),
            fakeYearOfBirth = faker.number().numberBetween(10, 99);


}
