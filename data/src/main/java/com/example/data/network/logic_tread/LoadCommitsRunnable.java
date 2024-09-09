package com.example.data.network.logic_tread;

import android.content.Context;

import com.example.data.entities.CommitsApi;
import com.example.data.entities.RepositoriesApi;
import com.example.data.entities.Token;
import com.example.data.network.module.RetrofitProvider;
import com.example.data.shared.TokenSharedPreference;
import com.example.domain.entities.Commits;
import com.example.domain.entities.Repositories;
import com.example.domain.utils.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class LoadCommitsRunnable implements Runnable {
    RetrofitProvider retrofitProvider = new RetrofitProvider();
    List<Commits> commitsList = new ArrayList<>();
    volatile Result<List<Commits>> result = new Result.Loading();
    public String owner = "";
    public String repo = "";

    @Override
    public void run() {
        try {
            Call<List<CommitsApi>> call = retrofitProvider.getRepositoryCommitsApi().getRepositoriesCommits(
                    owner,
                    repo
            );
            Response<List<CommitsApi>> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                for (CommitsApi commitsApi : response.body()) {
                    commitsList.add(commitsApi.toCommits());
                }
                result = new Result.OK(commitsList);
            } else {
                result = new Result.Error(response.errorBody().toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Result<List<Commits>> getResult() {
        return result;
    }
}
