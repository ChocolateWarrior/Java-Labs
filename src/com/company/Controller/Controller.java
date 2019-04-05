package com.company.Controller;

import com.company.Model.InputScanner;
import com.company.Model.Car;
import com.company.Model.Executable;
import com.company.Validators.InputValidator;
import com.company.View.Viewer;
import com.company.Model.Container;
import com.company.Exceptions.UserException;

import java.io.IOException;


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

        Executable exe = new Executable();

        InputScanner inputScanner = new InputScanner();
        int indicator = 0;
        try {
            showMenu();
            indicator = inputScanner.scanNum();
        }
        catch (java.util.InputMismatchException e){
            Viewer.view("Exception in input occurred! ");
            manageControl();
        }

        Car[] resArr;

        label: while (indicator == 1 || indicator == 2 || indicator == 3 || indicator == 4 ) {
            switch (indicator) {
                case 1:
                    String str1;
                    try {
                        Viewer.view("Type your mark:");
                        str1 = inputScanner.scanString();
                    }
                    catch (java.util.InputMismatchException e) {
                        Viewer.view("Exception in input occurred! ");
                        break;
                    }
                    resArr = exe.getCarByMark(str1);
                    viewCarArr(resArr);
                    break;
                case 2:
                    String str2;
                    int num1;
                    try {
                        Viewer.view("Type your model:");
                        str2 = inputScanner.scanString();
                        Viewer.view("Type your car age:");
                        num1 = inputScanner.scanNum();
                        InputValidator.checkAge(num1);
                    }
                    catch (java.util.InputMismatchException e){
                        Viewer.view("Exception in input occured!");
                        break;
                    }
                    catch (UserException e){
                        Viewer.view(e.getMessage() + "\n Your input age was: " + e.getNumber());
                        break;
                    }
                    resArr = exe.modelExpluatationFilter(str2, num1);
                    viewCarArr(resArr);

                    break;
                case 3:
                    int num2;
                    int num3;
                    try {
                        Viewer.view("Type your year:");
                        num2 = inputScanner.scanNum();
                        Viewer.view("Type your price:");
                        num3 = inputScanner.scanNum();
                        InputValidator.checkYear(num2);
                        InputValidator.checkPrice(num3);
                    }
                    catch (java.util.InputMismatchException e){
                        Viewer.view("Exception in input occured!");
                        break;
                    }
                    catch (UserException e){
                        Viewer.view(e.getMessage());
                        break;
                    }
                    resArr = exe.priceExpluatationFilter(num2, num3);
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
                indicator = inputScanner.scanNum();
            }
            catch (java.util.InputMismatchException exception){
                Viewer.view("Message:");
                Viewer.view(exception.getMessage());
                manageControl();
            }

        }
    }

}
