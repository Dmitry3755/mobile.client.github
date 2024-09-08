package com.example.domain.use_case;

import android.content.Context;

import com.example.domain.entities.Repositories;
import com.example.domain.repositories.SharedPreferenceRepository;
import com.example.domain.repositories.UserRepositoriesRepository;
import com.example.domain.utils.Result;

import java.util.List;

public class InitializeSharedPreferenceUseCase {
    public void invoke(SharedPreferenceRepository sharedPreferenceRepository, Context context) {
        sharedPreferenceRepository.initializeSharedPreference(context);
    }
}
