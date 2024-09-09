package com.example.domain.use_case;

import android.content.Context;

import com.example.domain.repositories.ExchangeCodeRepository;
import com.example.domain.utils.Result;

public class ExchangeCodeForTokenUseCase{
    public static Result<String> invoke(ExchangeCodeRepository exchangeCodeRepository, String code, Context context) throws InterruptedException {
        return exchangeCodeRepository.exchangeCodeForToken(code, context);
    }
}
