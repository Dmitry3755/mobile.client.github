package com.example.githubservice.ui.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;

public class NetworkStateReceiver extends BroadcastReceiver {

    private final ConnectivityManager connectivityManager;
    private NetworkStateListener listener;

    public NetworkStateReceiver(Context context, NetworkStateListener listener) {
        this.listener = listener;
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
            context.registerReceiver(this, filter);
        } else {
            NetworkRequest request = new NetworkRequest.Builder().build();
            connectivityManager.registerNetworkCallback(request, new ConnectivityManager.NetworkCallback() {
                @Override
                public void onAvailable(Network network) {
                    listener.onNetworkStateChanged(true);
                }

                @Override
                public void onLost(Network network) {
                    listener.onNetworkStateChanged(false);
                }
            });
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            boolean isConnected = checkInternetConnection(context);
            listener.onNetworkStateChanged(isConnected);
        }
    }

    private boolean checkInternetConnection(Context context) {
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }
        return false;
    }

    public interface NetworkStateListener {
        void onNetworkStateChanged(boolean isConnected);
    }
}
