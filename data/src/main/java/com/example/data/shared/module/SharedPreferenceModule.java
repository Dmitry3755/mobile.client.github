package com.example.data.shared.module;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceModule {

    public SharedPreferences sharedPreference;
    private static SharedPreferenceModule instance;
    private String SHARED_PREFERENCE_NAME = "GITHUB_APP";

    public SharedPreferenceModule(Context context) {
        sharedPreference = context.getSharedPreferences(
                SHARED_PREFERENCE_NAME,
                Context.MODE_PRIVATE
        );
    }

    public static synchronized SharedPreferenceModule getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferenceModule(context);
        }
        return instance;
    }
}