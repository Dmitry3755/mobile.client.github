package com.example.domain.use_case;

import android.content.Context;

import com.example.domain.repositories.UserAuthRepository;

public class SignInUseCase {
    public static void invoke(UserAuthRepository userAuthRepository, String login, String password, Context context) {
        userAuthRepository.signIn(login, password, context);
    }
}
