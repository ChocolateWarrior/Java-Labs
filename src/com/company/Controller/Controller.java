package com.company.Controller;

import com.company.Reader;
import com.company.Model.Car;
import com.company.Model.CarService;
import com.company.Validators.InputValidator;
import com.company.View.Viewer;
import com.company.Model.Container;
import com.company.Exceptions.WrongNumberException;
import com.company.FileIO.*;


public class Controller {

    private void viewCarInTable(Car car){
        Viewer.view(car.toStr());
    }

    private void viewCarArr(Car[] cars){
        if(cars.length > 0) {
            Viewer.view("        Name    Model        ID        Price Colour RegNum   Year");

            for (Car car : cars) {
                viewCarInTable(car);
            }
        }
        else Viewer.view("No such car!");
    }

    private void showTable(){
        Viewer.view("        Name    Model        ID        Price Colour RegNum   Year");
        for (Car car : Container.getCarArray()) {
            if(car != null) {
                viewCarInTable(car);
            }
        }
        Viewer.view("");

    }

    private void showMenu(){
        Viewer.view("What would you like to do?");
        Viewer.view("OPTIONS:\n" +
                "[1] to search by mark\n" +
                "[2] to search model, with usage year higher than chosen\n" +
                "[3] to search car with exact year but price higher than chosen\n" +
                "[4] to show car table\n" +
                "[any other integer] to exit");
    }

    public void manageControl(){

        //Reading file to set car array  in container
        Car [] arrayToSet = FileInput.getArrayFromFileInput();
        Container.setArray(arrayToSet);

        CarService exe = new CarService();

        int indicator = 0;
        try {
            showMenu();
            indicator = Reader.scanNum();
        }
        catch (java.util.InputMismatchException e){
            Viewer.view("Exception in input occurred! ");
            manageControl();
        }

        Car[] resArr;
        boolean isFirstIteration = true;

        label: while (indicator > 0 && indicator < 5 ) {
            switch (indicator) {
                case 1:
                    String str1;
                    try {
                        Viewer.view("Type your mark:");
                        str1 = Reader.scanString();
                    }
                    catch (java.util.InputMismatchException e) {
                        Viewer.view("Exception in input occurred! ");
                        break;
                    }
                    resArr = exe.getCarByMark(str1);
                    if (isFirstIteration) {
                        Container.setResultCarArray(resArr);
                        isFirstIteration = false;
                    } else Container.appendToResultCarArray(resArr, resArr.length);

                    try {
                        FileOutput.writeToFile();
                        FileOutput.writeSerializedToFile();
                        FileOutput.writeJSONtoFile();
                    }catch (Exception e){
                        Viewer.view("Exception has occurred while writing to file!");
                        break;
                    }
                    viewCarArr(resArr);
                    break;
                case 2:
                    String str2;
                    int num1;
                    try {
                        Viewer.view("Type your model:");
                        str2 = Reader.scanString();
                        Viewer.view("Type your car age:");
                        num1 = Reader.scanNum();
                        InputValidator.checkAge(num1);
                    }
                    catch (java.util.InputMismatchException e){
                        Viewer.view("Exception in input occurred!");
                        break;
                    }
                    catch (WrongNumberException e){
                        Viewer.view(e.getMessage() + "\n Your input age was: " + e.getNumber());
                        break;
                    }

                    resArr = exe.modelExpluatationFilter(str2, num1);
                    if (isFirstIteration) {
                        Container.setResultCarArray(resArr);
                        isFirstIteration = false;
                    } else Container.appendToResultCarArray(resArr, resArr.length);

                    try {
                        FileOutput.writeToFile();
                        FileOutput.writeSerializedToFile();
                        FileOutput.writeJSONtoFile();
                    }catch (Exception e){
                        Viewer.view("Exception has occurred while writing to file!");
                        break;
                    }
                    viewCarArr(resArr);

                    break;
                case 3:
                    int num2;
                    int num3;
                    try {
                        Viewer.view("Type your year:");
                        num2 = Reader.scanNum();
                        Viewer.view("Type your price:");
                        num3 = Reader.scanNum();
                        InputValidator.checkYear(num2);
                        InputValidator.checkPrice(num3);
                    }
                    catch (java.util.InputMismatchException e){
                        Viewer.view("Exception in input occurred!");
                        break;
                    }
                    catch (WrongNumberException e){
                        Viewer.view(e.getMessage());
                        break;
                    }
                    resArr = exe.priceExpluatationFilter(num2, num3);
                    if (isFirstIteration) {
                        Container.setResultCarArray(resArr);
                        isFirstIteration = false;
                    } else Container.appendToResultCarArray(resArr, resArr.length);

                    try {
                        FileOutput.writeToFile();
                        FileOutput.writeSerializedToFile();
                        FileOutput.writeJSONtoFile();
                    }catch (Exception e){
                        Viewer.view("Exception has occurred while writing to file!");
                        break;
                    }
                    viewCarArr(resArr);

                    break;
                case 4:
                        showTable();
                    break;
                default:

                    break label;

            }

            showMenu();
            try {
                indicator = Reader.scanNum();
            }
            catch (java.util.InputMismatchException exception){
                Viewer.view("Error occurred in input!");
                manageControl();
            }

        }
    }

}
