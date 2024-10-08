package com.example.data.network.repositories_impl;

import android.content.Context;

import com.example.data.network.logic_tread.TokenRunnable;
import com.example.data.network.module.RetrofitModule;
import com.example.data.network.module.RetrofitProvider;
import com.example.domain.repositories.ExchangeCodeRepository;
import com.example.domain.utils.Result;

public class ExchangeCodeRepImpl implements ExchangeCodeRepository {

    @Override
    public Result<String> exchangeCodeForToken(String code, Context context) throws InterruptedException {
        if (RetrofitModule.retrofitClient == null) {
            RetrofitModule.getClient();
        }
        TokenRunnable tokenRunnable = new TokenRunnable();
        tokenRunnable.code = code;
        tokenRunnable.context = context;
        Thread flow = new Thread(tokenRunnable);
        flow.start();
        flow.join();
        return tokenRunnable.getResult();
    }
}