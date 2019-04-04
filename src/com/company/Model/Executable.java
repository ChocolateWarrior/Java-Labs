package com.company.Model;


import java.util.Objects;

public class Executable {

    public Car[] getCarByMark(String name){

        int length = 0;
        int index = 0;

        for (Car car : Container.getCarArray()) {
            if (car != null) {
                if (car.getMark().equals(name)) {
                    length++;

                }
            }
        }
        Car [] resArr = new Car [length];

        for (Car car : Container.getCarArray()) {
            if (car != null) {
                if (car.getMark().equals(name)) {
                    resArr[index] = car;
                    index++;
                }

            }
        }

        return resArr;

    }

    public Car [] modelExpluatationFilter(String model, int age){

        int length = 0;
        int index = 0;

        for (Car car : Container.getCarArray()) {


            if (car != null) {
                if (Objects.equals(car.getModel(), model) && age < 2018 - car.getProductionYear()) {
                    length++;
                }
            }
        }

        Car [] resArr = new Car [length];

        for (Car car : Container.getCarArray()) {


            if (car != null) {
                if (Objects.equals(car.getModel(), model) && age < 2018 - car.getProductionYear()) {
                    resArr[index] = car;
                    index++;
                }
            }
        }
        return resArr;

    }

    public Car [] priceExpluatationFilter(int productionYear, int price){

        int length = 0;
        int index = 0;

        for (Car car : Container.getCarArray()) {
            if (car != null) {
                if ((car.getProductionYear() == productionYear) && (car.getPrice() > price)) {
                    length++;
                }

            }
        }

        Car [] resArr = new Car [length];

        for (Car car : Container.getCarArray()) {
            if (car != null) {
                if ((car.getProductionYear() == productionYear) && (car.getPrice() > price)) {
                    resArr[index] = car;
                    index++;
                }

            }
        }
        return resArr;

    }


}
