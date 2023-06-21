package com.example.smartlab;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;
}
