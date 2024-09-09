package com.example.domain.repositories;

import android.content.Context;

import java.util.Map;

public interface UserAuthRepository {
    void signIn(String login, String password, Context context);
    Map<String, String> getUserAuthData(Context context);
}
