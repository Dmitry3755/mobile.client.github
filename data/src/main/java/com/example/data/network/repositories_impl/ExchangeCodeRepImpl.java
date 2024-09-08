package com.example.data.network.repositories_impl;

import android.util.Log;

import com.example.data.entities.Token;
import com.example.data.network.logic_tread.RepositoriesListRunnable;
import com.example.data.network.logic_tread.TokenRunnable;
import com.example.data.network.module.RetrofitModule;
import com.example.data.network.module.RetrofitProvider;
import com.example.domain.repositories.ExchangeCodeRepository;
import com.example.domain.utils.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExchangeCodeRepImpl implements ExchangeCodeRepository {
    Result<String> result = new Result.Loading();
    RetrofitProvider retrofitProvider = new RetrofitProvider();

    @Override
    public Result<String> exchangeCodeForToken(String code) throws InterruptedException {
        if (RetrofitModule.retrofitClient == null) {
            RetrofitModule.getClient();
        }
        TokenRunnable tokenRunnable = new TokenRunnable();
        Thread flow = new Thread(tokenRunnable);
        flow.start();
        flow.join();
        String a = tokenRunnable.token.getAccessToken();
        return  tokenRunnable.getResult();
/*
        if (RetrofitModule.retrofitClient == null) {
            RetrofitModule.getClient();
        }

        Call<Token> response = retrofitProvider.getAuthApi().getAccessToken(
                "Ov23liH6j6SME8WrXulg",
                "0a55c6f3cd4e4648aea42ebf8b4456a1f54ff62f",
                code
        );
        response.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.isSuccessful() && response.body() != null) {
                    response.body().getAccessToken();
                    result = new Result.OK("");
                } else {
                    result = new Result.Error(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.e("Error. Get Token", t.getMessage());
                result = new Result.Error(t.getMessage());
            }
        });
        return result;*/
    }
}