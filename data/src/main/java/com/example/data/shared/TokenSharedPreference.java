package com.example.data.shared;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.data.shared.module.SharedPreferenceModule;

public class TokenSharedPreference {
    private String SHARED_PREFERENCE_ACCESS_TOKEN = "ACCESS_TOKEN";
    private static TokenSharedPreference instance;

    public TokenSharedPreference() {}

    public static synchronized TokenSharedPreference getInstance() {
        if (instance == null) {
            instance = new TokenSharedPreference();
        }
        return instance;
    }

    public String getToken(Context context) {
        return SharedPreferenceModule.getInstance(context).sharedPreference.getString(SHARED_PREFERENCE_ACCESS_TOKEN, null);
    }

    public void setToken(String value, Context context) {
        SharedPreferences.Editor editor = SharedPreferenceModule.getInstance(context).sharedPreference.edit();
        editor.putString(SHARED_PREFERENCE_ACCESS_TOKEN, value);
        editor.apply();
    }
}
