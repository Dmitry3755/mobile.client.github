package com.example.data.network.module;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceModule {

    private SharedPreferences sharedPreference = null;
    private String SHARED_PREFERENCE_NAME = "GITHUB_APP";
    private String SHARED_PREFERENCE_ACCESS_TOKEN = "ACCESS_TOKEN";

    SharedPreferences.Editor editor = sharedPreference.edit();
    String savedToken = sharedPreference.getString(SHARED_PREFERENCE_ACCESS_TOKEN, null);

    void initializeSharedPreference(Context context) {
        sharedPreference = context.getSharedPreferences(
                SHARED_PREFERENCE_NAME,
                Context.MODE_PRIVATE
        );
    }
}
