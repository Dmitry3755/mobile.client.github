package com.example.domain.use_case;

import com.example.domain.repositories.ExchangeCodeRepository;
import com.example.domain.utils.Result;

public class ExchangeCodeForTokenUseCase{
    public static Result<String> invoke(ExchangeCodeRepository exchangeCodeRepository, String code) throws InterruptedException {
        return exchangeCodeRepository.exchangeCodeForToken(code);
    }
}
