package com.example.domain.repositories;

import com.example.domain.entities.Commits;
import com.example.domain.utils.Result;

import java.util.List;

public interface CommitRepository {
    Result<List<Commits>> getCommitsList(String owner, String repo) throws InterruptedException;
}
