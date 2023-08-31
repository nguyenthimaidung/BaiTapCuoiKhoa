package com.vmo.nopcommerce.utils;

import com.github.javafaker.Faker;

public class RegisterData {
    public static String FIRSTNAME = "Mai";
    public static String LASTNAME = "Dung";
    public static String EMAIL = generateEmail();
    public static String PASSWORD = "12345678";
    public static String CF_PASSWORD ="12345678";


     static String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    };
}
