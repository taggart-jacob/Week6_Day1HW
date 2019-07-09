package com.example.week6_day1hw.view.activities.gitrepoactivity;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week6_day1hw.model.datasource.gitpojo.ProfileGit;
import com.example.week6_day1hw.model.datasource.gitpojo.RepoObject;
import com.example.week6_day1hw.model.datasource.remote.RetrofitGit;
import com.example.week6_day1hw.view.adapters.GitReposRecyclerViewAdapter;
import com.example.week6_day1hw.view.adapters.GitReposRecyclerViewPresenter;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitReposActivityPresenter {
    GitReposActivityContract gitReposActivityContract;
    ArrayList<RepoObject> repoObjects;
    public GitReposActivityPresenter(GitReposActivityContract gitReposActivityContract){
        this.gitReposActivityContract = gitReposActivityContract;
    }

    public void getRepoObjects(Context context){
        Log.d("TAG", "HELLO");
        RetrofitGit retrofitGit = new RetrofitGit();
        retrofitGit.getService().getGitRepos("https://api.github.com/users/taggart-jacob/repos").enqueue(new Callback<RepoObject[]>() {
            @Override
            public void onResponse(Call<RepoObject[]> call, Response<RepoObject[]> response) {
                Log.d("TAG", "HELLO");
                RepoObject[] repoObject = response.body();
                ((GitReposActivity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayList<RepoObject> arrayList = new ArrayList<RepoObject>(Arrays.asList(repoObject));
                        gitReposActivityContract.returnGitRepos(arrayList);
                        Log.d("TAG", repoObject[0].getName()+" dsds");
                    }
                });
            }



            @Override
            public void onFailure(Call<RepoObject[]> call, Throwable t) {
                Log.e("TAG", t.getMessage());
            }
        });

    }
}
