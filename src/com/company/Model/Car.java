package com.company.Model;

import java.io.Serializable;

public class Car implements Serializable {

    private String idNum, mark, model, colour, regNum;
    private int productionYear, price;

    Car(){
        idNum = "undefined";
        mark = "undefined";
        model = "undefined";
        colour = "undefined";
        regNum = "undefined";

        productionYear = 0;
        price = 0;
    }

    public Car(String id, String mrk, String mdl, String clr, String rg, int prdYr, int prc){
        idNum = id;
        mark = mrk;
        model = mdl;
        colour = clr;
        regNum = rg;

        productionYear = prdYr;
        price = prc;
    }


    public void setIdNum(String id){
        this.idNum = id;
    }

    public void setMark(String mrk){
        this.mark = mrk;
    }

    public void setModel(String mdl){
        this.model = mdl;
    }

    public void setColour(String clr){
        this.colour = clr;
    }

    public void regNum(String rg){
        this.regNum = rg;
    }

    public void setProductionYear(int year){
        this.productionYear = year;
    }

    public void setPrice(int prc){
        this.price = prc;
    }


    private String getIdNum(){
        return this.idNum;
    }

    String getMark(){
        return this.mark;
    }

    String getModel(){
        return this.model;
    }

    private String getColour(){
        return this.colour;
    }

    private String getRegNum(){
        return this.regNum;
    }

    int getProductionYear(){
        return this.productionYear;
    }

    int getPrice(){
        return this.price;
    }

    public String toStr(){

        return String.format("%12s",this.getMark()) +
                String.format("%9s",this.getModel())+
                String.format("%16s",this.getIdNum())+
                String.format("%7d",this.getPrice())+
                String.format("%7s",this.getColour())+
                String.format("%9s",this.getRegNum())+
                String.format("%5d", this.getProductionYear());

    }
}
