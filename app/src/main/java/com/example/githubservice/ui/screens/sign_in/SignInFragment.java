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

import com.example.data.entities.Token;
import com.example.githubservice.R;
import com.example.githubservice.databinding.FmtSignInBinding;
import com.example.githubservice.ui.view_models.UserAuthorizationViewModel;
import com.example.githubservice.utils.OAuthModule;

import java.util.Map;

public class SignInFragment extends Fragment {

    private FmtSignInBinding binding;
    private UserAuthorizationViewModel userAuthorizationViewModel;
    private Map<String, String> userLocalDataMap;

    public SignInFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeComponents();
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
        setUserData();
        binding.signInButton.setOnClickListener(
                v -> {
                    if (checkUserLocalData("access_token")) {
                        Token.getInstance().setAccessToken(userLocalDataMap.get("access_token").toString());
                        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_navigation_sign_in_to_navigation_repositories);
                    } else {
                        if ((!binding.signInLoginEditText.getText().toString().equals("") && binding.signInLoginEditText.getText() != null) && (!binding.signInPasswordEditText.getText().toString().equals("") && binding.signInPasswordEditText.getText() != null)) {
                            userAuthorizationViewModel.sigIn(binding.signInLoginEditText.getText().toString(), binding.signInPasswordEditText.getText().toString(), requireContext());
                            Intent intent = new Intent(Intent.ACTION_VIEW, OAuthModule.getUri());
                            startActivity(intent);
                        } else {
                            binding.loginTextInputLayout.setError(requireContext().getText(R.string.fmt_sign_up_in_required));
                            binding.passwordTextInputLayout.setError(requireContext().getText(R.string.fmt_sign_up_in_required));
                        }
                    }
                }
        );
    }

    void setUserData() {
        if (checkUserLocalData("login")) {
            binding.signInLoginEditText.setText(userLocalDataMap.get("login").toString());
        }
        if (checkUserLocalData("password")) {
            binding.signInPasswordEditText.setText(userLocalDataMap.get("password").toString());
        }
    }

    Boolean checkUserLocalData(String key) {
        if (userLocalDataMap.get(key) != null) {
            return true;
        }
        return false;
    }

    void initializeComponents() {
        userAuthorizationViewModel = new UserAuthorizationViewModel();
        userLocalDataMap = userAuthorizationViewModel.getUserDataAuth(requireContext());
    }
}