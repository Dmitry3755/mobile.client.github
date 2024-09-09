package com.example.githubservice.utils;

import android.content.Context;

public class ConverterDpPx {

    public int convertPxToDp(int px, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round(px / density);
    }

    public int convertDpToPx(int dp, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

}
