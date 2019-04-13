package com.company;

import java.util.Scanner;

public class Reader {


    public static int scanNum(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String scanString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
