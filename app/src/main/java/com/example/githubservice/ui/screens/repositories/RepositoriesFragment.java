package com.example.githubservice.ui.screens.repositories;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.domain.entities.Repositories;
import com.example.domain.utils.Result;
import com.example.githubservice.R;
import com.example.githubservice.databinding.ActGitHubServiceBinding;
import com.example.githubservice.databinding.FmtRepositoriesBinding;
import com.example.githubservice.databinding.FmtSignInBinding;
import com.example.githubservice.ui.view_models.UserAuthorizationViewModel;
import com.example.githubservice.ui.view_models.UserRepositoriesViewModel;
import com.example.githubservice.utils.ErrorToast;

import java.util.List;

public class RepositoriesFragment extends Fragment {

    private FmtRepositoriesBinding binding;
    private UserRepositoriesViewModel userRepositoriesViewModel;
    private ErrorToast errorToast;

    public RepositoriesFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeComponent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FmtRepositoriesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            Result<List<Repositories>> result = userRepositoriesViewModel.getRepositories();
            if(Result.Error.class == result.getClass()) {
                errorToast.printErrorToast(requireContext(), ((Result.Error) result).getError(), true);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void initializeComponent() {
        userRepositoriesViewModel = new UserRepositoriesViewModel();
        errorToast = new ErrorToast();
    }
}