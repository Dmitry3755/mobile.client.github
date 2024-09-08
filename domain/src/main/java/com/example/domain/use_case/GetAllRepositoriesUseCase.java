package com.example.domain.use_case;

import com.example.domain.entities.Repositories;
import com.example.domain.repositories.ExchangeCodeRepository;
import com.example.domain.repositories.UserRepositoriesRepository;
import com.example.domain.utils.Result;

import java.util.List;

public class GetAllRepositoriesUseCase {
    public static Result<List<Repositories>> invoke(UserRepositoriesRepository userRepositoriesRepository) throws InterruptedException {
        return userRepositoriesRepository.getAllRepositories();
    }
}
