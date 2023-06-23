package com.example.smartlab;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BannerResult {

    @SerializedName("count")
    private String count;    @SerializedName("next")
    private String next;    @SerializedName("previous")
    private String previous;    @SerializedName("results")

    private List<Banner> banners;
    public List<Banner> getBanners(){
        return banners;
    }
}
