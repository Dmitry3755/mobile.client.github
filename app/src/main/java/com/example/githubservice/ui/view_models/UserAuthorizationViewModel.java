package com.example.githubservice.ui.view_models;

import androidx.lifecycle.ViewModel;

import com.example.data.network.repositories_impl.ExchangeCodeRepImpl;
import com.example.domain.repositories.ExchangeCodeRepository;
import com.example.domain.use_case.ExchangeCodeForTokenUseCase;
import com.example.domain.use_case.SignInUseCase;
import com.example.domain.utils.Result;

public class UserAuthorizationViewModel extends ViewModel {
    ExchangeCodeRepository exchangeCodeRepository = new ExchangeCodeRepImpl();
    private SignInUseCase signInUseCase = null;

    public void sigIn(String login, String password) {
        signInUseCase = new SignInUseCase();
        signInUseCase.invoke(login, password);
    }

    public Result<String> exchangeCodeForToken(String code) throws InterruptedException {
       return ExchangeCodeForTokenUseCase.invoke(exchangeCodeRepository, code);
    }

}

