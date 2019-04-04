package com.company.Validators;

import com.company.Exceptions.UserException;

public class InputValidator {
    public static void checkPrice(int price) throws UserException {
        if(price < 0 || price > 10000000) {
            throw new UserException("Price out of range!", price);
        }
    }
    public static void checkAge(int age) throws UserException {
        if(age <= 0 || age >= 30) {
            throw new UserException("Age out of range!", age);
        }
    }
    public static void checkYear(int year) throws UserException {
        if(year < 1990 || year > 2020) {
            throw new UserException("Year out of range!", year);
        }
    }
}