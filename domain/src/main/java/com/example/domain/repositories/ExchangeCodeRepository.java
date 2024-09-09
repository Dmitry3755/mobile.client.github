package com.example.domain.repositories;

import android.content.Context;

import com.example.domain.utils.Result;

public interface ExchangeCodeRepository {
    Result<String> exchangeCodeForToken(String code, Context context) throws InterruptedException;
}
