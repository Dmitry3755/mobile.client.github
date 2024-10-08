package com.example.githubservice.ui.screens.list_repositories.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.entities.Repositories;
import com.example.githubservice.R;
import com.example.githubservice.ui.screens.list_repositories.transform.CircularTransformation;
import com.example.githubservice.ui.view_models.RepositoryViewModel;
import com.example.githubservice.utils.PicassoIV;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RepositoriesRvAdapter extends RecyclerView.Adapter<RepositoriesRvAdapter.ViewHolder> {

    private List<Repositories> repositoriesList = null;
    private final NavController navController;
    private RepositoryViewModel repositoryViewModel;
    PicassoIV picassoIV = new PicassoIV();

    public RepositoriesRvAdapter(List<Repositories> repositoriesList, NavController navController, RepositoryViewModel viewModel) {
        this.repositoriesList = repositoriesList;
        this.navController = navController;
        this.repositoryViewModel = viewModel;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Context context;
        public TextView repositoriesNameTextView;
        public TextView nameOwnerTextView;
        public TextView descriptionRepositoriesTextView;
        public TextView countForksTextView;
        public TextView countWatchesTextView;
        public ImageView avatarImageView;
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            view = itemView;
            repositoriesNameTextView = itemView.findViewById(R.id.repositories_name_text_view);
            nameOwnerTextView = itemView.findViewById(R.id.name_owner_text_view);
            descriptionRepositoriesTextView = itemView.findViewById(R.id.description_repositories_text_view);
            countForksTextView = itemView.findViewById(R.id.count_forks_text_view);
            countWatchesTextView = itemView.findViewById(R.id.count_watches_text_view);
            avatarImageView = itemView.findViewById(R.id.avatar_image_view);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_repository, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.repositoriesNameTextView.setText(repositoriesList.get(position).name);
        holder.nameOwnerTextView.setText(repositoriesList.get(position).owner.login);
        holder.descriptionRepositoriesTextView.setText(repositoriesList.get(position).description);
        holder.countForksTextView.setText(holder.context.getText(R.string.recycler_view_forks) + repositoriesList.get(position).forksCount.toString());
        holder.countWatchesTextView.setText(holder.context.getText(R.string.recycler_view_watches) + repositoriesList.get(position).watchers.toString());
        picassoIV.getPicasso(repositoriesList.get(position)).into(holder.avatarImageView);
        holder.view.setOnClickListener(v -> {
            repositoryViewModel.setRepository(repositoriesList.get(position));
            navController.navigate(R.id.action_navigation_repositories_to_repositoryFragment);
        });
    }

    @Override
    public int getItemCount() {
        return repositoriesList.size();
    }
}
