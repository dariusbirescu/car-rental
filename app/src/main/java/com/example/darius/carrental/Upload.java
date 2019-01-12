package com.example.darius.carrental;

public class Upload {
    private String mName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String model;
    private String year;
    private String price;

    public Upload(){
        //empty
    }

    public Upload(String name, String mImageUrl, String model, String year, String price){
        if(name.trim().equals("")){
            name="No name";
        }

        mName=name;
        this.mImageUrl=mImageUrl;
        this.model=model;
        this.year=year;
        this.price=price;
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    private String mImageUrl;
}
