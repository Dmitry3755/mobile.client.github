package com.example.githubservice.ui.screens.repository.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.entities.Commits;
import com.example.domain.entities.Repositories;
import com.example.githubservice.R;
import com.example.githubservice.ui.view_models.RepositoryViewModel;
import com.example.githubservice.utils.PicassoIV;

import java.util.List;

public class CommitsRvAdapter extends RecyclerView.Adapter<CommitsRvAdapter.ViewHolder> {

    private List<Commits> commitsList;

    public CommitsRvAdapter(List<Commits> commitsList) {
        this.commitsList = commitsList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        TextView hashTextView;
        TextView commitTextView;
        TextView authorTextView;
        TextView dateTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            hashTextView = itemView.findViewById(R.id.hash_text_view);
            commitTextView = itemView.findViewById(R.id.commit_text_view);
            authorTextView = itemView.findViewById(R.id.author_text_view);
            dateTextView = itemView.findViewById(R.id.date_text_view);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_commit, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.hashTextView.setText(holder.context.getText(R.string.commit_hash) + commitsList.get(position).sha);
        if (commitsList.get(position).commit.message.length() > 45) {
            holder.commitTextView.setText(commitsList.get(position).commit.message.substring(0, 45));
        } else {
            holder.commitTextView.setText(commitsList.get(position).commit.message);
        }
        holder.authorTextView.setText(commitsList.get(position).commit.author.name);
        holder.dateTextView.setText(commitsList.get(position).commit.author.date);
    }

    @Override
    public int getItemCount() {
        return commitsList.size();
    }
}
