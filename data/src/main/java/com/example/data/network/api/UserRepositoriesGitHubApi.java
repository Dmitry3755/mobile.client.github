package com.example.data.network.api;

import com.example.data.entities.RepositoriesApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface UserRepositoriesGitHubApi {
    @GET("user/repos")
    Call<List<RepositoriesApi>> getUserRepositories(@Header("Authorization") String authToken);

    @GET("repos/{owner}/{repo}")
    RepositoriesApi getRepositoriesDetails(@Path("owner") String owner, @Path("repo") String repo);
}
