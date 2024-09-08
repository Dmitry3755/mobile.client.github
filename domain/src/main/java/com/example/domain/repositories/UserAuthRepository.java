package com.example.domain.repositories;

public interface UserAuthRepository {
    void signIn(String login, String password);
}
