package com.example.data.network.logic_tread;

import android.content.Context;

import com.example.data.entities.Token;
import com.example.data.network.module.RetrofitProvider;
import com.example.data.shared.TokenSharedPreference;
import com.example.domain.utils.Result;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class TokenRunnable implements Runnable {
    RetrofitProvider retrofitProvider = new RetrofitProvider();
    Result<String> result = new Result.Loading();
    public String code = "";
    public Context context;
    @Override
    public void run() {
        try {
            Call<Token> call = retrofitProvider.getAuthApi().getAccessToken(
                    "Ov23liH6j6SME8WrXulg",
                    "0a55c6f3cd4e4648aea42ebf8b4456a1f54ff62f",
                    code
            );
            Response<Token> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                Token.getInstance().setAccessToken(response.body().getAccessToken());
                TokenSharedPreference.getInstance().setToken(response.body().getAccessToken(),context);
                result = new Result.OK<>("Token получен");
            } else {
                result = new Result.Error(response.errorBody().string());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Result<String> getResult() {
        return result;
    }
}
