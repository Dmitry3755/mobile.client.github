package com.example.data.shared;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.data.shared.module.SharedPreferenceModule;

public class UserAuthSharedPreference {
    private String SHARED_PREFERENCE_LOGIN = "LOGIN";
    private String SHARED_PREFERENCE_PASSWORD = "PASSWORD";
    private static UserAuthSharedPreference instance;

    public UserAuthSharedPreference() {}

    public static synchronized UserAuthSharedPreference getInstance() {
        if (instance == null) {
            instance = new UserAuthSharedPreference();
        }
        return instance;
    }

    public String getLogin(Context context) {
        return SharedPreferenceModule.getInstance(context).sharedPreference.getString(SHARED_PREFERENCE_LOGIN, null);
    }

    public void setLogin(String value, Context context) {
        SharedPreferences.Editor editor = SharedPreferenceModule.getInstance(context).sharedPreference.edit();
        editor.putString(SHARED_PREFERENCE_LOGIN, value);
        editor.apply();
    }

    public String getPassword(Context context) {
        return SharedPreferenceModule.getInstance(context).sharedPreference.getString(SHARED_PREFERENCE_PASSWORD, null);
    }

    public void setPassword(String value, Context context) {
        SharedPreferences.Editor editor = SharedPreferenceModule.getInstance(context).sharedPreference.edit();
        editor.putString(SHARED_PREFERENCE_PASSWORD, value);
        editor.apply();
    }
}
