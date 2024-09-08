package com.example.data.network.api;

import com.example.data.entities.CommitsApi;
import com.example.data.entities.RepositoriesApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserRepositoriesCommitsGitHubApi {
    @GET("repos/{owner}/{repo}/commits")
    Call<List<CommitsApi>> getRepositoriesCommits(@Path("owner") String owner, @Path("repo") String repo);
}