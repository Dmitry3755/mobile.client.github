package com.example.data.network.logic_tread;

import android.util.Log;

import com.example.data.entities.RepositoriesApi;
import com.example.data.entities.Token;
import com.example.data.network.module.RetrofitModule;
import com.example.data.network.module.RetrofitProvider;
import com.example.domain.entities.Repositories;
import com.example.domain.utils.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TokenRunnable implements Runnable {
   RetrofitProvider retrofitProvider = new RetrofitProvider();
   public Token token = new Token();
    public String code ="";
    volatile Result<String> result = new Result.Loading();

    @Override
    public void run() {
        Call<Token> response = retrofitProvider.getAuthApi().getAccessToken(
                "Ov23liH6j6SME8WrXulg",
                "0a55c6f3cd4e4648aea42ebf8b4456a1f54ff62f",
                code
        );
        response.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.isSuccessful() && response.body() != null) {
                    token = response.body();
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
    }

    public Result<String> getResult() {
        return result;
    }
}
