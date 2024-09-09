package com.example.data.network.module;

import com.example.data.network.api.UserAuthGitHubApi;
import com.example.data.network.api.UserRepositoriesCommitsGitHubApi;
import com.example.data.network.api.UserRepositoriesGitHubApi;

public class RetrofitProvider {

    public UserAuthGitHubApi getAuthApi() {
        return RetrofitModule.retrofitClient.create(UserAuthGitHubApi.class);
    }

    public UserRepositoriesGitHubApi getRepositoriesApi() {
        return RetrofitModule.retrofitApiClient.create(UserRepositoriesGitHubApi.class);
    }

    public UserRepositoriesCommitsGitHubApi getRepositoryCommitsApi() {
        return RetrofitModule.retrofitApiClient.create(UserRepositoriesCommitsGitHubApi.class);
    }

}
