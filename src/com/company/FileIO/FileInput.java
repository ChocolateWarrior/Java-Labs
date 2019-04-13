package com.company.FileIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.company.Model.Car;

import static java.lang.Integer.parseInt;

public class FileInput {

    private static Car getCarFromLine(String line){
        String csvSplitBy = ",";
        String [] parameters = line.split(csvSplitBy);
        for(String par : parameters) System.out.print(par + ' ');
        System.out.println("\n");

        return new Car (parameters[0],parameters[1],parameters[2],
                parameters[3],parameters[4],parseInt(parameters[5]),
                parseInt(parameters[6]));
    }

    public static Car [] getArrayFromFileInput(){

        int length;
        String line;
        String fileName = "/home/helvetica/IdeaProjects/Lab1/src/com/company/FileIO/input.csv";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            length = parseInt(bufferedReader.readLine());

            Car [] resultCarArray = new Car [length];
            int currentIndex = 0;
            while((line = bufferedReader.readLine()) != null) {
                resultCarArray[currentIndex] = getCarFromLine(line);
                currentIndex++;
            }
            bufferedReader.close();
            return resultCarArray;
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }

        return new Car [0];

    }
}
