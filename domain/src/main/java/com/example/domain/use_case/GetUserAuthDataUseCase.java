package com.example.domain.use_case;

import android.content.Context;

import com.example.domain.repositories.UserAuthRepository;

import java.util.Map;

public class GetUserAuthDataUseCase {
    public static Map<String, String> invoke(UserAuthRepository userAuthRepository, Context context) {
       return userAuthRepository.getUserAuthData(context);
    }
}
