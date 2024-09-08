package com.example.githubservice.utils;

import android.content.Context;
import android.widget.Toast;

public class ErrorToast {
    public Toast printErrorToast(Context context, String errorText, Boolean lengthShort) {
        if (lengthShort) {
            return Toast.makeText(context, errorText, Toast.LENGTH_SHORT);
        } else {
            return Toast.makeText(context, errorText, Toast.LENGTH_LONG);
        }
    }
}
