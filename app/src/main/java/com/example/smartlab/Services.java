package com.example.smartlab;

public class Services {
    public String nameService;
    public String data;
    public String price;

    Services (String nameService, String data, String price){
        this.nameService = nameService;
        this.data = data;
        this.price = price;
    }

    public String getNameService() {
        return nameService;
    }

    public String getData() {
        return data;
    }

    public String getPrice() {
        return price;
    }
}
