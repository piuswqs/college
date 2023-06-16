package com.example.smartlab;

public class OnBoardingItem {
    private int image;
    private String title;
    private String description;

    OnBoardingItem(String title, String description, int image){
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
