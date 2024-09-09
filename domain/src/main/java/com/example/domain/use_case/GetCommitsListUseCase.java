package com.example.domain.use_case;

import android.content.Context;

import com.example.domain.entities.Commits;
import com.example.domain.repositories.CommitRepository;
import com.example.domain.repositories.UserAuthRepository;
import com.example.domain.utils.Result;

import java.util.List;

public class GetCommitsListUseCase {
    public static Result<List<Commits>> invoke(CommitRepository commitRepository, String owner, String repo) throws InterruptedException {
        return commitRepository.getCommitsList(owner, repo);
    }
}
