package com.example.data.network.module;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceModule {
    private static final SharedPreferenceModule INSTANCE = new SharedPreferenceModule();
    private static SharedPreferences sharedPreference;
    private String SHARED_PREFERENCE_NAME = "GITHUB_APP";
    private String SHARED_PREFERENCE_ACCESS_TOKEN = "ACCESS_TOKEN";

    public static SharedPreferenceModule getInstance() {
        return INSTANCE;
    }

    public String getToken() {
       return sharedPreference.getString(SHARED_PREFERENCE_ACCESS_TOKEN, null);
    }

    public void setToken(String value) {
        sharedPreference.edit().putString(SHARED_PREFERENCE_ACCESS_TOKEN, value);
    }

    public void initializeSharedPreference(Context context) {
        sharedPreference = context.getSharedPreferences(
                SHARED_PREFERENCE_NAME,
                Context.MODE_PRIVATE
        );
    }
}
