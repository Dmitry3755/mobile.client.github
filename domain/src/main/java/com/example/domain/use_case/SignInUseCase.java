package com.example.domain.use_case;

import com.example.domain.repositories.UserAuthRepository;

public class SignInUseCase {
    UserAuthRepository UserAuthRepository;
    public void invoke(String login, String password) {
        UserAuthRepository.signIn(login, password);
    }
}
