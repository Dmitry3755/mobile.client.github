package com.example.githubservice.ui.screens.sign_in;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.githubservice.R;
import com.example.githubservice.databinding.FmtSignInBinding;
import com.example.githubservice.utils.OAuthModule;

public class SignInFragment extends Fragment {

    private FmtSignInBinding binding;

    public SignInFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FmtSignInBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.signInButton.setOnClickListener(
                v -> {
                    Intent intent = new Intent(Intent.ACTION_VIEW, OAuthModule.getUri());
                    startActivity(intent);
                }
        );
    }
}