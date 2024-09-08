package com.example.data.network.logic_tread;

import android.util.Log;

import com.example.data.entities.RepositoriesApi;
import com.example.data.entities.Token;
import com.example.data.network.api.UserAuthGitHubApi;
import com.example.data.network.module.RetrofitModule;
import com.example.data.network.module.RetrofitProvider;
import com.example.domain.entities.Repositories;
import com.example.domain.utils.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class RepositoriesListRunnable implements Runnable {
    RetrofitProvider retrofitProvider = new RetrofitProvider();
    Token token = new Token();
    List<Repositories> repositoriesList = new ArrayList<>();
    volatile Result<List<Repositories>> result = new Result.Loading();

    @Override
    public void run() {
        try {
            Response<List<RepositoriesApi>> response = retrofitProvider.getRepositoriesApi().getUserRepositories("Bearer " + token.getAccessToken());
            if (response.isSuccessful() && response.body() != null) {
                for (RepositoriesApi repositoriesApi : response.body()) {
                    repositoriesList.add(repositoriesApi.toRepositories());
                }
                result = new Result.OK(repositoriesList);
            } else {
                result = new Result.Error(response.errorBody().string());
            }
        } catch (Exception e) {
            Log.e("Error. Get repositories", e.getMessage());
            result = new Result.Error(e.getMessage());

        }
    }

    public Result<List<Repositories>> getListRepositories() {
        return result;
    }
}
