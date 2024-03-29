package com.example.week6_day1hw.view.activities.gitrepoactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.week6_day1hw.R;
import com.example.week6_day1hw.model.datasource.gitpojo.RepoObject;
import com.example.week6_day1hw.view.adapters.GitReposRecyclerViewAdapter;
import java.util.ArrayList;


public class GitReposActivity extends AppCompatActivity implements GitReposActivityContract {

    GitReposActivityPresenter gitReposPresenter;
    RecyclerView rvRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_repos);
        rvRepos = findViewById(R.id.rvRepos);
        gitReposPresenter = new GitReposActivityPresenter(this);
        gitReposPresenter.getRepoObjects(this);
    }

    @Override
    public void returnGitRepos(ArrayList<RepoObject> repoObjects) {
        GitReposRecyclerViewAdapter gitReposRecyclerViewAdapter = new GitReposRecyclerViewAdapter(repoObjects);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvRepos.setLayoutManager(layoutManager);
        rvRepos.setAdapter(gitReposRecyclerViewAdapter);
    }
}
