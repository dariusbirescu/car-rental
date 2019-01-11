package com.example.darius.carrental;

public class Car {

    private String Model;
    private String Price ;
    private String Year ;
    private int Thumbnail ;

    public Car(String model, String price, String year, int thumbnail) {
        Model = model;
        Price = price;
        Year = year;
        Thumbnail = thumbnail;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
