package com.example.githubservice.ui.screens.sign_in;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.githubservice.R;
import com.example.githubservice.databinding.ActGitHubServiceBinding;
import com.example.githubservice.databinding.FmtSignInBinding;

public class SignInFragment extends Fragment {

    private FmtSignInBinding binding;

    public SignInFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FmtSignInBinding.inflate(getLayoutInflater());
        return FmtSignInBinding.inflate(inflater, container, false).getRoot();
    }


}