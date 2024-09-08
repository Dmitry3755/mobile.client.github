package com.example.data.network.repositories_impl;

import com.example.data.network.module.RetrofitModule;
import com.example.data.network.logic_tread.RepositoriesListRunnable;
import com.example.domain.entities.Repositories;
import com.example.domain.repositories.UserRepositoriesRepository;
import com.example.domain.utils.Result;

import java.util.List;

public class UserRepositoriesRepImpl implements UserRepositoriesRepository {
    @Override
    public Result<List<Repositories>> getAllRepositories() throws InterruptedException {
        if (RetrofitModule.retrofitApiClient == null) {
            RetrofitModule.getApiClient();
        }
        RepositoriesListRunnable repositoriesListRunnable = new RepositoriesListRunnable();
        Thread flow = new Thread(repositoriesListRunnable);
        flow.start();
        flow.join();
        return repositoriesListRunnable.getResult();
    }

}
