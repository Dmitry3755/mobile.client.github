package com.example.domain.entities;

public class Commit {
    public Author author;
    public String message;

    public Commit(Author author, String message) {
        this.author = author;
        this.message = message;
    }
}
