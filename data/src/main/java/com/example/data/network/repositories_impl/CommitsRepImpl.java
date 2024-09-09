package com.example.data.network.repositories_impl;

import com.example.data.network.logic_tread.LoadCommitsRunnable;
import com.example.data.network.module.RetrofitModule;
import com.example.domain.entities.Commits;
import com.example.domain.repositories.CommitRepository;
import com.example.domain.utils.Result;

import java.util.Collections;
import java.util.List;

public class CommitsRepImpl implements CommitRepository {
    @Override
    public Result<List<Commits>> getCommitsList(String owner, String repo) throws InterruptedException {
        if (RetrofitModule.retrofitApiClient == null) {
            RetrofitModule.getApiClient();
        }
        LoadCommitsRunnable loadCommitsRunnable = new LoadCommitsRunnable();
        Thread flow = new Thread(loadCommitsRunnable);
        loadCommitsRunnable.owner = owner;
        loadCommitsRunnable.repo = repo;
        flow.start();
        flow.join();
        return loadCommitsRunnable.getResult();
    }
}
