package com.example.data.entities;

import com.example.domain.entities.Author;
import com.google.gson.annotations.SerializedName;

public class AuthorApi {
    @SerializedName("name")
    public String name;
    @SerializedName("email")
    public String email;
    @SerializedName("date")
    public String date;

    public Author toAuthor() {
        return new Author(name, email,date);
    }
}
