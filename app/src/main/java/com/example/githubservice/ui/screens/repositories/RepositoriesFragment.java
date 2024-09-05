package com.example.githubservice.ui.screens.repositories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.githubservice.R;

public class RepositoriesFragment extends Fragment {

    public RepositoriesFragment() {
        // Required empty public constructor
    }

    public static RepositoriesFragment newInstance(String param1, String param2) {
        RepositoriesFragment fragment = new RepositoriesFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fmt_repositories, container, false);
    }
}