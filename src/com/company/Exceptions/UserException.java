package com.company.Exceptions;

public class UserException extends Exception {

    private int number;

    public UserException(String msg) {
        super(msg);
    }

    public UserException(String msg, int number) {
        super(msg);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
