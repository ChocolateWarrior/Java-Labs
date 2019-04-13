package com.company.Validators;

import com.company.Exceptions.WrongNumberException;

public class InputValidator {
    public static void checkPrice(int price) throws WrongNumberException {
        if(price < 0 || price > 10000000) {
            throw new WrongNumberException("Price out of range!", price);
        }
    }
    public static void checkAge(int age) throws WrongNumberException {
        if(age <= 0 || age >= 30) {
            throw new WrongNumberException("Age out of range!", age);
        }
    }
    public static void checkYear(int year) throws WrongNumberException {
        if(year < 1990 || year > 2020) {
            throw new WrongNumberException("Year out of range!", year);
        }
    }
}