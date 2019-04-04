package com.company.Model;


class SourceData {

    private String [] carMarkArr = {"KIA", "Volkswagen", "Hyundai", "Audi", "BMW", "Mercedes"};
    private String [] carModelArr = {"Cerato", "Veloster", "Polo", "A8", "5 series", "GLC"};
    private String [] colorArr = {"White", "Silver", "Black", "Brown", "Red", "Cyan"};
    private String [] idNumArr = {"ID1111123$Q0001", "ID1111123$20002", "ID1111123$Q0003", "ID1111123$Q0004", "ID1111123$a0005", "ID1111123$Q0006"};
    private String [] registrationNumArr = {"BI7170AI", "BI7171AI", "BI7172AI", "BI7173AI", "BI7174AI", "BI7175AI"};
    private int [] productionYearArr = {1999, 2000, 2001, 2010, 2011, 2012};
    private int [] priceArr = { 100000, 200000, 300000, 550000, 890000, 1999000};

    private static Car[] carArr = { new Car("ID1111123$Q0001", "KIA", "Cee`d", "Coffee", "BI7170AI", 2013, 250000),
            new Car("ID1111123$20002", "KIA", "Cee`d", "Coffee", "BI7169AI", 2012, 280000),
            new Car("ID1111123$Q0003", "KIA", "Cerato", "Red", "BI7171AI", 2017, 370000),
            new Car("ID1111123$Q0004", "KIA", "Cee`d", "Cyan", "BI7172AI", 2012, 240000),
            new Car("ID1111123$a0005", "Mercedes", "W212", "Red", "BI7173AI", 2010, 299999),
            new Car("ID1111123$Q0006", "BMW", "M3", "Black", "BI7174AI", 2005, 221000),
            new Car("ID1111123$Q0007", "BMW", "M4", "Silver", "BI7175AI", 2006, 200000),
            new Car("ID1111123$Q0008", "Range Rover", "Sport", "Cyan", "BI7176AI", 2013, 900000),
            new Car("ID1111123$Q0009", "Lada", "Kalina", "Black", "BI7177AI", 2009, 150000),
            new Car("ID1111123$Q0010", "Volkswagen", "Scirocco", "White", "BI7178AI", 2016, 450000),
            new Car("ID1111123$Q0011", "Volkswagen", "Golf", "White", "BI7179AI", 2015, 380000),
            new Car("ID1111123$Q0012", "Hyundai", "i30", "Red", "BI7180AI", 2012, 220000)};


    String [] getCarMarkArr(){
        return this.carMarkArr;
    }
    String [] getCarModelArr(){
        return this.carModelArr;
    }
    String [] getColorArr(){
        return this.colorArr;
    }
    String [] getIdNumArr(){
        return this.idNumArr;
    }
    String [] getRegistrationNumArr(){
        return this.registrationNumArr;
    }
    int [] getProductionYearArr(){
        return this.productionYearArr;
    }
    int [] getPriceArr(){
        return this.priceArr;
    }


    static Car [] getConstCarArr(){
        return carArr;
    }

}
