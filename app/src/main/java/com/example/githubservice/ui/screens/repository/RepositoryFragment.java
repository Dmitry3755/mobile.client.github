package com.example.githubservice.ui.screens.repository;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.entities.Commits;
import com.example.domain.entities.Repositories;
import com.example.domain.utils.Result;
import com.example.githubservice.R;
import com.example.githubservice.databinding.FmtRepositoryBinding;
import com.example.githubservice.ui.screens.activity.GitHubServiceActivity;
import com.example.githubservice.ui.screens.list_repositories.adapter.RepositoriesRvAdapter;
import com.example.githubservice.ui.screens.repository.adapter.CommitsRvAdapter;
import com.example.githubservice.ui.view_models.RepositoryViewModel;
import com.example.githubservice.utils.PicassoIV;

import java.util.List;

public class RepositoryFragment extends Fragment {

    private RepositoryViewModel repositoryViewModel;
    private FmtRepositoryBinding binding;
    private PicassoIV picassoIV;
    private RecyclerView commitsRecyclerView;
    private CommitsRvAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FmtRepositoryBinding.inflate(inflater, container, false);
        initializeComponent();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            repositoryViewModel.getCommitsList(repositoryViewModel.getRepository().owner.login, repositoryViewModel.getRepository().name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        initializeElements();
    }

    void initializeElements() {
        binding.nameOwnerTextView.setText(repositoryViewModel.getRepository().owner.login);
        picassoIV.getPicasso(repositoryViewModel.getRepository()).into(binding.avatarImageView);
        commitsRecyclerView = binding.repositoriesRecyclerView;
        commitsRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new CommitsRvAdapter(repositoryViewModel.commits);
        commitsRecyclerView.setAdapter(adapter);
    }

    void initializeComponent() {
        repositoryViewModel = ((GitHubServiceActivity) requireActivity()).getRepositoryViewModel();
        picassoIV = new PicassoIV();
    }
}
