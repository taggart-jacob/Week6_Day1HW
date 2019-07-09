package com.example.week6_day1hw.view.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week6_day1hw.R;
import com.example.week6_day1hw.model.datasource.gitpojo.RepoObject;

import java.util.ArrayList;

public class GitReposRecyclerViewAdapter extends RecyclerView.Adapter<GitReposRecyclerViewAdapter.ViewHolder> implements GitReposRecyclerViewContract{

    private ArrayList<RepoObject> repoObjects;
    private GitReposRecyclerViewPresenter gitReposRecyclerViewPresenter;
    private ViewHolder holder;

    public GitReposRecyclerViewAdapter(ArrayList<RepoObject> repoObjects){
        this.repoObjects = repoObjects;
        this.gitReposRecyclerViewPresenter = new GitReposRecyclerViewPresenter(this);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RepoObject repoObject = repoObjects.get(position);
        holder.tvRepoName.setText(repoObject.getName());
        holder.tvRepoUser.setText(repoObject.getOwner().getLogin());
        holder.tvRepoLanguage.setText(repoObject.getLanguage());
        this.holder = holder;
    }

    @Override
    public int getItemCount() {
        return repoObjects.size();
    }

    @Override
    public void returnRepoObjects() {

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvRepoName;
        TextView tvRepoUser;
        TextView tvRepoLanguage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRepoName = itemView.findViewById(R.id.tvRepoName);
            tvRepoUser = itemView.findViewById(R.id.tvRepoUser);
            tvRepoLanguage = itemView.findViewById(R.id.tvRepoLanguage);
        }
    }
}
