package com.example.data.network.logic_tread;

import android.util.Log;

import com.example.data.entities.RepositoriesApi;
import com.example.data.entities.Token;
import com.example.data.network.api.UserAuthGitHubApi;
import com.example.data.network.module.RetrofitModule;
import com.example.data.network.module.RetrofitProvider;
import com.example.data.network.module.SharedPreferenceModule;
import com.example.domain.entities.Repositories;
import com.example.domain.repositories.SharedPreferenceRepository;
import com.example.domain.utils.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoriesListRunnable implements Runnable {
    RetrofitProvider retrofitProvider = new RetrofitProvider();
    List<Repositories> repositoriesList = new ArrayList<>();
    volatile Result<List<Repositories>> result = new Result.Loading();

    @Override
    public void run() {
        try {
            Call<List<RepositoriesApi>> call = retrofitProvider.getRepositoriesApi().getUserRepositories("Bearer " + Token.getInstance().getAccessToken());
            Response<List<RepositoriesApi>> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                for (RepositoriesApi repositoriesApi : response.body()) {
                    repositoriesList.add(repositoriesApi.toRepositories());
                }
                result = new Result.OK(repositoriesList);
            } else {
                result = new Result.Error(response.errorBody().toString());
            }
        } catch (IOException e) {
            Log.e("Error. Get repositories", e.getMessage());
            result = new Result.Error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Result<List<Repositories>> getResult() {return result;}
}
