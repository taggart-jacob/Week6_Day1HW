package com.example.week6_day1hw.view.adapters;

import com.example.week6_day1hw.model.datasource.gitpojo.RepoObject;

import java.util.ArrayList;

public class GitReposRecyclerViewPresenter {

    GitReposRecyclerViewContract gitReposRecyclerViewContract;

    public GitReposRecyclerViewPresenter(GitReposRecyclerViewContract gitReposRecyclerViewContract){
        this.gitReposRecyclerViewContract = gitReposRecyclerViewContract;
    }

    public void getRepos(){
        gitReposRecyclerViewContract.returnRepoObjects();
    }
}
