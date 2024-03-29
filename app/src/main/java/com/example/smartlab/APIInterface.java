package com.example.smartlab;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    @POST("signup/")
    Call<User> SignUp(@Body User user);

    @GET("catalog/")
    Call<AnalysisResult> getAnalyses();

    @GET("news/")
    Call<BannerResult> getNews();

    @POST("signin/")
    Call<Refresh> SignIn(@Body User user);}