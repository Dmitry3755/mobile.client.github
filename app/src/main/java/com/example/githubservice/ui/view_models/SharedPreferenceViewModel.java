package com.example.githubservice.ui.view_models;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.data.network.repositories_impl.SharedPreferenceRepImpl;
import com.example.domain.repositories.SharedPreferenceRepository;

public class SharedPreferenceViewModel extends ViewModel {
    SharedPreferenceRepository sharedPreferenceRepository = new SharedPreferenceRepImpl();

    public void initializeSharedPreference(Context context) {
        sharedPreferenceRepository.initializeSharedPreference(context);
    }

}
