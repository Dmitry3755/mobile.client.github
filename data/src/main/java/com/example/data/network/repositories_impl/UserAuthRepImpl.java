package com.example.data.network.repositories_impl;

import android.content.Context;

import com.example.data.network.api.UserAuthGitHubApi;
import com.example.data.shared.TokenSharedPreference;
import com.example.data.shared.UserAuthSharedPreference;
import com.example.domain.repositories.UserAuthRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserAuthRepImpl implements UserAuthRepository {

    @Override
    public void signIn(String login, String password, Context context) {
        UserAuthSharedPreference.getInstance().setLogin(login,context);
        UserAuthSharedPreference.getInstance().setPassword(password,context);
    }

    @Override
    public Map<String, String> getUserAuthData(Context context) {
        Map<String, String> userDataMap = new HashMap<>();
        userDataMap.put("login", UserAuthSharedPreference.getInstance().getLogin(context));
        userDataMap.put("password", UserAuthSharedPreference.getInstance().getPassword(context));
        userDataMap.put("access_token", TokenSharedPreference.getInstance().getToken(context));
        return userDataMap;
    }
}
