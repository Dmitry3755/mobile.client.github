package com.example.githubservice.ui.view_models;

import androidx.lifecycle.ViewModel;

import com.example.data.network.repositories_impl.CommitsRepImpl;
import com.example.domain.entities.Commits;
import com.example.domain.entities.Repositories;
import com.example.domain.repositories.CommitRepository;
import com.example.domain.use_case.GetCommitsListUseCase;
import com.example.domain.utils.Result;

import java.util.ArrayList;
import java.util.List;

public class RepositoryViewModel extends ViewModel {

    CommitRepository commitRepository = new CommitsRepImpl();

    private Repositories repositories;
    public List<Commits> commits;
    private Result<List<Commits>> result;

    public void setRepository(Repositories repositories) {
        this.repositories = repositories;
    }

    public Repositories getRepository() {
        return repositories;
    }

    public void getCommitsList(String owner, String repo) throws InterruptedException {
        result = GetCommitsListUseCase.invoke(commitRepository, owner, repo);
        if(result.getClass() == Result.OK.class) {
            commits = ((Result.OK<List<Commits>>) GetCommitsListUseCase.invoke(commitRepository, owner, repo)).getResult();
        }
        else {
            commits = new ArrayList<>();
        }
    }
}
