package com.example.domain.repositories;

import com.example.domain.entities.Repositories;
import com.example.domain.utils.Result;

import java.util.List;

public interface UserRepositoriesRepository {
    Result<List<Repositories>> getAllRepositories() throws InterruptedException;
}
