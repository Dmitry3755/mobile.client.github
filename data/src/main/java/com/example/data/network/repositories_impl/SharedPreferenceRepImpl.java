package com.example.data.network.repositories_impl;

import android.content.Context;

import com.example.data.network.module.SharedPreferenceModule;
import com.example.domain.repositories.SharedPreferenceRepository;

public class SharedPreferenceRepImpl implements SharedPreferenceRepository {
    @Override
    public void initializeSharedPreference(Context context) {
        SharedPreferenceModule sharedPreferenceModule = new SharedPreferenceModule();
        sharedPreferenceModule.initializeSharedPreference(context);
    }
}
