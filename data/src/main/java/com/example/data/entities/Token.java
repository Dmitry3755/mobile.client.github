package com.example.data.entities;

import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("access_token")
    private String accessToken;

    private static Token instance;

    private Token() { }

    public static synchronized Token getInstance() {
        if (instance == null) {
            instance = new Token();
        }
        return instance;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
