package com.example.githubservice.utils;

import android.net.Uri;

public class OAuthModule {
    private static final String CLIENT_ID = "Ov23liH6j6SME8WrXulg";

    public static Uri getUri() {
        return Uri.parse("https://github.com/login/oauth/authorize")
                .buildUpon()
                .appendQueryParameter("client_id", CLIENT_ID)
                .appendQueryParameter("scope", "repo")
                .build();
    }
}
