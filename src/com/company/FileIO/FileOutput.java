package com.company.FileIO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

import com.company.Model.Car;
import com.company.Model.Container;
import com.google.gson.Gson;

public class FileOutput {


    public static void writeToFile() throws Exception{

        FileWriter fileWriter = new FileWriter("/home/helvetica/IdeaProjects/Lab1/src/com/company/FileIO/output.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Car car : Container.getResultCarArray()){
            bufferedWriter.write(car.toStr() + "\n");
        }

        bufferedWriter.close();
    }

    public static void writeSerializedToFile(){

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/helvetica/IdeaProjects/Lab1/src/com/company/FileIO/serializedOutput.dat")))
        {
            for(Car car : Container.getResultCarArray()) {
                oos.writeObject(car);
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

    }

    public static void writeJSONtoFile () throws Exception{

        FileWriter fileWriter = new FileWriter("/home/helvetica/IdeaProjects/Lab1/src/com/company/FileIO/JSONOutput.json");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Gson gson = new Gson();

        for (Car car : Container.getResultCarArray()){
            String jsonString = gson.toJson(car);
            bufferedWriter.write(jsonString + "\n");
        }

        bufferedWriter.close();
    }

}
