package com.example.githubservice.ui.screens.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.example.githubservice.databinding.ActGitHubServiceBinding;
import com.example.githubservice.R;

public class GitHubServiceActivity extends AppCompatActivity {

    private ActGitHubServiceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActGitHubServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}