package com.example.githubservice.ui.view_models;

import androidx.lifecycle.ViewModel;

import com.example.data.network.repositories_impl.ExchangeCodeRepImpl;
import com.example.data.network.repositories_impl.UserRepositoriesRepImpl;
import com.example.domain.entities.Repositories;
import com.example.domain.repositories.ExchangeCodeRepository;
import com.example.domain.repositories.UserRepositoriesRepository;
import com.example.domain.use_case.ExchangeCodeForTokenUseCase;
import com.example.domain.use_case.GetAllRepositoriesUseCase;
import com.example.domain.use_case.SignInUseCase;
import com.example.domain.utils.Result;

import java.util.List;

public class UserRepositoriesViewModel extends ViewModel {
    UserRepositoriesRepository userRepositoriesRepository = new UserRepositoriesRepImpl();

    public Result<List<Repositories>> getRepositories() throws InterruptedException {
       return GetAllRepositoriesUseCase.invoke(userRepositoriesRepository);
    }
}

