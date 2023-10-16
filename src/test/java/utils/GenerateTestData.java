package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class GenerateTestData {

    Faker faker = new Faker(new Locale("en-GB"));

    public String generateRandomSubject() {
        String[] subjects = {"Maths", "English", "Chemistry", "Computer science", "Commerce", "Economics"};
        int n = faker.number().numberBetween(0, subjects.length);
        return (subjects[n]);
    }

    public String generateRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November"};
        int n = faker.number().numberBetween(0, months.length);
        return (months[n]);
    }

    public String generateRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        int n = faker.number().numberBetween(0, genders.length);
        return (genders[n]);
    }

    public String generateRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int n = faker.number().numberBetween(0, states.length);
        return (states[n]);
    }

    public String generateRandomCity(String randomState) {
        String[] ncrCity = {"Delhi", "Gurgaon", "Noida"};
        String[] uttarPradeshCity = {"Agra", "Lucknow", "Merrut"};
        String[] haryanaCity = {"Karnal", "Panipat"};
        String[] rajasthanCity = {"Jaipur", "Jaiselmer"};

        if (randomState.equals("NCR")) {
            return faker.options().option(ncrCity);
        } else if (randomState.equals("Uttar Pradesh")) {
            return faker.options().option(uttarPradeshCity);
        } else if (randomState.equals("Haryana")) {
            return faker.options().option(haryanaCity);
        } else if (randomState.equals("Rajasthan")) {
            return faker.options().option(rajasthanCity);
        }
        return null;
    }
}