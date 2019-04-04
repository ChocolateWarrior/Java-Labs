package com.company.Model;



import java.util.Random;

class Generator {

    private Random random;

    Generator(){
        random = new Random();
    }

    void generate( SourceData sourceData){
        for(int i = 0; i < Container.getCarArray().length; i++){

            Container.getCarArray()[i] = new Car(sourceData.getIdNumArr()[random.nextInt(5) + 1], sourceData.getCarMarkArr()[random.nextInt(5) + 1],
                    sourceData.getCarModelArr()[random.nextInt(5) + 1], sourceData.getColorArr()[random.nextInt(5) + 1],
                    sourceData.getRegistrationNumArr()[random.nextInt(5) + 1],
                    sourceData.getProductionYearArr()[random.nextInt(5) + 1], sourceData.getPriceArr()[random.nextInt(5) + 1]);

        }

    }

}

//TODO add storage class DONE