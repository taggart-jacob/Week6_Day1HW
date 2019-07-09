package com.example.week6_day1hw.view.adapters;

public class GitReposRecyclerViewPresenter {

    GitReposRecyclerViewContract gitReposRecyclerViewContract;

    public GitReposRecyclerViewPresenter(GitReposRecyclerViewContract gitReposRecyclerViewContract){
        this.gitReposRecyclerViewContract = gitReposRecyclerViewContract;
    }

    public void getRepos(){
        gitReposRecyclerViewContract.returnRepoObjects();
    }
}
