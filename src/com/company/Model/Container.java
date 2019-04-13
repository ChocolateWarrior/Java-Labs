package com.company.Model;


public class Container {

    private static Car [] carArray = SourceData.getConstCarArr();
    private static Car [] resultCarArray;

    public static void setArray( Car [] arrayToSet){
        carArray = arrayToSet;
    }
    public static void setResultCarArray( Car [] arrayToSet){resultCarArray = arrayToSet;}
    public static Car [] getCarArray(){
        return carArray;
    }
    public static Car[] getResultCarArray() { return resultCarArray; }
    public static void appendToResultCarArray(Car [] arrayToAppend, int appendedLength){
        int curLength = resultCarArray.length > 0 ? resultCarArray.length : 0;
        Car [] appendArr = new Car [curLength + appendedLength];
        int i = 0;
        for(Car car : resultCarArray){
            appendArr[i] = car;
            i++;
        }
        for(Car car : arrayToAppend){
            appendArr[i] = car;
            i++;
        }

        resultCarArray = appendArr;
    }
}
