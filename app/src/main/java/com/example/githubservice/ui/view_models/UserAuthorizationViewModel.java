package com.example.githubservice.ui.view_models;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.data.network.repositories_impl.ExchangeCodeRepImpl;
import com.example.data.network.repositories_impl.UserAuthRepImpl;
import com.example.domain.repositories.ExchangeCodeRepository;
import com.example.domain.repositories.UserAuthRepository;
import com.example.domain.use_case.ExchangeCodeForTokenUseCase;
import com.example.domain.use_case.GetUserAuthDataUseCase;
import com.example.domain.use_case.SignInUseCase;
import com.example.domain.utils.Result;

import java.util.Map;

public class UserAuthorizationViewModel extends ViewModel {
    ExchangeCodeRepository exchangeCodeRepository = new ExchangeCodeRepImpl();
    UserAuthRepository userAuthRepository = new UserAuthRepImpl();

    public void sigIn(String login, String password, Context context) {
        SignInUseCase.invoke(userAuthRepository, login, password, context);
    }

    public Map<String, String> getUserDataAuth(Context context) {
        return GetUserAuthDataUseCase.invoke(userAuthRepository, context);
    }

    public Result<String> exchangeCodeForToken(String code, Context context) throws InterruptedException {
        return ExchangeCodeForTokenUseCase.invoke(exchangeCodeRepository, code, context);
    }

}

