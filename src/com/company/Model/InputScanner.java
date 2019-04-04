package com.company.Model;

import java.util.Scanner;

public class InputScanner {


    public int scanNum(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String scanString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
