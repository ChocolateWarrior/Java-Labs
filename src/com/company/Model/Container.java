package com.company.Model;


public class Container {


    private static Car [] carArray = SourceData.getConstCarArr();

    public static Car [] getCarArray(){
        return carArray;
    }

}
