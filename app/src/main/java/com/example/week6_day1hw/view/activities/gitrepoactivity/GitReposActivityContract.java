package com.example.week6_day1hw.view.activities.gitrepoactivity;

import com.example.week6_day1hw.model.datasource.gitpojo.RepoObject;

import java.util.ArrayList;

public interface GitReposActivityContract {
    void returnGitRepos(ArrayList<RepoObject> repoObjects);
}
