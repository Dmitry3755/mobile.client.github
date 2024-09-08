package com.example.githubservice.ui.screens.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import com.example.domain.utils.Result;
import com.example.githubservice.R;
import com.example.githubservice.databinding.ActGitHubServiceBinding;
import com.example.githubservice.ui.view_models.UserAuthorizationViewModel;
import com.example.githubservice.utils.ErrorToast;

public class GitHubServiceActivity extends AppCompatActivity {

    private ActGitHubServiceBinding binding;
    private UserAuthorizationViewModel viewModel;
    private ErrorToast errorToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeComponent();
        setContentView(binding.getRoot());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri uri = intent.getData();
        if (uri != null && uri.toString().startsWith("myapp://callback")) {
            if (uri.getQueryParameter("code") != null) {
                Result<String> result = null;
                try {
                    result = viewModel.exchangeCodeForToken(uri.getQueryParameter("code"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (Result.Error.class == result.getClass()) {
                    errorToast.printErrorToast(this, ((Result.Error) result).getError(), true).show();
                } else {
                  //  Navigation.findNavController(binding.getRoot()).navigate(R.id.action_navigation_sign_in_to_navigation_repositories);
                }
            } else {
                errorToast.printErrorToast(this, getString(R.string.error), true).show();
            }
        }
    }

    void initializeComponent() {
        viewModel = new UserAuthorizationViewModel();
        errorToast = new ErrorToast();
        binding = ActGitHubServiceBinding.inflate(getLayoutInflater());
    }
}
