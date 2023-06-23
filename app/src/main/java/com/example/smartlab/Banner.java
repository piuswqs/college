package com.example.smartlab;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class Banner {
    Integer id;
    String name;
    String description;
    String price;
    String image;

    public Banner(Integer id, String name, String description, String price, String image){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public String getPriceFormat() {
        double priceDouble = Double.parseDouble(price);
        int priceInt = (int) priceDouble;
        String javaFormatString  = "%d ₽";
        String  substitutedString  =  String.format(javaFormatString, priceInt);
        return substitutedString;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
