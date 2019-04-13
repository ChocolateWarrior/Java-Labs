package com.company.Exceptions;

public class WrongNumberException extends Exception {

    private int number;

    public WrongNumberException(String msg) {
        super(msg);
    }

    public WrongNumberException(String msg, int number) {
        super(msg);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
