package com.example.domain.repositories;

import com.example.domain.utils.Result;

public interface ExchangeCodeRepository {
    Result<String> exchangeCodeForToken(String code) throws InterruptedException;
}
