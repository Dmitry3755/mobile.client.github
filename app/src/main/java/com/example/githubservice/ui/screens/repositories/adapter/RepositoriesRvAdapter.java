package com.example.githubservice.ui.screens.repositories.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.entities.Repositories;
import com.example.githubservice.R;
import com.example.githubservice.ui.screens.repositories.transform.CircularTransformation;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RepositoriesRvAdapter extends RecyclerView.Adapter<RepositoriesRvAdapter.ViewHolder> {

    private List<Repositories> repositoriesList = null;

    public RepositoriesRvAdapter(List<Repositories> repositoriesList) {
        this.repositoriesList = repositoriesList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Context context;
        public TextView repositoriesNameTextView;
        public TextView nameOwnerTextView;
        public TextView descriptionRepositoriesTextView;
        public TextView countForksTextView;
        public TextView countWatchesTextView;
        public ImageView avatarImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
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
        Picasso.get()
                .load(repositoriesList.get(position).owner.avatarUrl)
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .transform(new CircularTransformation(0))
                .into(holder.avatarImageView);
    }

    @Override
    public int getItemCount() {
        return repositoriesList.size();
    }
}
