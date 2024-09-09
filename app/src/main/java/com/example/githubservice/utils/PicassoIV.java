package com.example.githubservice.utils;

import com.example.domain.entities.Repositories;
import com.example.githubservice.R;
import com.example.githubservice.ui.screens.list_repositories.transform.CircularTransformation;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class PicassoIV {

   public RequestCreator getPicasso(Repositories repositories) {
        return Picasso.get()
                .load(repositories.owner.avatarUrl)
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .transform(new CircularTransformation(0));
    }
}
