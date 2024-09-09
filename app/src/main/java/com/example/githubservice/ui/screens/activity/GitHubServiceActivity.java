package com.example.githubservice.ui.screens.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.data.shared.module.SharedPreferenceModule;
import com.example.domain.utils.Result;
import com.example.githubservice.R;
import com.example.githubservice.databinding.ActGitHubServiceBinding;
import com.example.githubservice.ui.screens.list_repositories.RepositoriesFragment;
import com.example.githubservice.ui.view_models.RepositoryViewModel;
import com.example.githubservice.ui.view_models.UserAuthorizationViewModel;
import com.example.githubservice.utils.ConverterDpPx;
import com.example.githubservice.utils.ErrorToast;
import com.example.githubservice.ui.broadcast_receiver.NetworkStateReceiver;

public class GitHubServiceActivity extends AppCompatActivity {

    private NetworkStateReceiver networkStateReceiver;
    private boolean isReceiverRegistered = false;
    private ActGitHubServiceBinding binding;
    private UserAuthorizationViewModel userAuthorizationViewModel;
    private ErrorToast errorToast;
    private ConverterDpPx converterDpPx;
    private Boolean networkState = true;
    private Result<String> result = null;
    private RepositoryViewModel repositoryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeComponent();
        setContentView(binding.getRoot());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (networkState) {
            hasInternetConnection(intent);
        } else {
            noInternetConnection();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!isReceiverRegistered) {
            IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(networkStateReceiver, filter);
            networkStateReceiver = new NetworkStateReceiver(this, returnRecyclerViewListener());
            isReceiverRegistered = true;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N && networkStateReceiver != null) {
            unregisterReceiver(networkStateReceiver);
        }
    }

    NetworkStateReceiver.NetworkStateListener returnRecyclerViewListener() {
        return isConnected -> {
            if (isConnected) {
                Log.d("Network", "Network on");
                networkState = true;
            } else {
                Log.d("Network", "Network off");
                noInternetConnection();
                networkState = false;
            }
        };
    }

    void initializeComponent() {
        userAuthorizationViewModel = new UserAuthorizationViewModel();
        errorToast = new ErrorToast();
        converterDpPx = new ConverterDpPx();
        repositoryViewModel = new ViewModelProvider(this).get(RepositoryViewModel.class);
        binding = ActGitHubServiceBinding.inflate(getLayoutInflater());
        SharedPreferenceModule.getInstance(this);

        binding.fragmentContainerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                binding.fragmentContainerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (converterDpPx.convertPxToDp(binding.fragmentContainerView.getWidth(), binding.getRoot().getContext()) > 500) {
                    ViewGroup.LayoutParams params = binding.fragmentContainerView.getLayoutParams();
                    params.width = converterDpPx.convertDpToPx(500, binding.getRoot().getContext());
                    binding.fragmentContainerView.setLayoutParams(params);
                }
            }
        });
    }

    void hasInternetConnection(Intent intent) {
        Uri uri = intent.getData();
        if (uri != null && uri.toString().startsWith("myapp://callback")) {
            if (uri.getQueryParameter("code") != null) {
                try {
                    result = userAuthorizationViewModel.exchangeCodeForToken(uri.getQueryParameter("code"), this);
                    if (Result.Error.class == result.getClass()) {
                        errorToast.printErrorToast(this, ((Result.Error) result).getError(), true).show();
                    } else if (Result.OK.class == result.getClass()) {
                        Navigation.findNavController(binding.fragmentContainerView).navigate(R.id.action_navigation_sign_in_to_navigation_repositories);
                    }
                } catch (InterruptedException e) {
                    errorToast.printErrorToast(this, getString(R.string.error_something_went_wrong), true).show();
                    throw new RuntimeException(e);
                }
            } else {
                errorToast.printErrorToast(this, getString(R.string.error_with_get_code), true).show();
            }
        }
    }

    void noInternetConnection() {
        errorToast.printErrorToast(this, getString(R.string.error_network), true).show();
    }

    public RepositoryViewModel getRepositoryViewModel() {
        return repositoryViewModel;
    }

}
