package com.example.week6_day1hw.view.activities.mainactivity;

import android.util.Log;

import com.example.week6_day1hw.model.datasource.gitpojo.ProfileGit;
import com.example.week6_day1hw.model.datasource.remote.RetrofitGit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter{
    MainActivityContract mainActivityContract;

    public MainActivityPresenter(MainActivityContract mainActivityContract){
        this.mainActivityContract = mainActivityContract;
    }

    public void getProfileGit(){
        RetrofitGit retrofitGit = new RetrofitGit();
        retrofitGit.getService().getGitObject("https://api.github.com/users/taggart-jacob").enqueue(new Callback<ProfileGit>() {
            @Override
            public void onResponse(Call<ProfileGit> call, Response<ProfileGit> response) {
                ProfileGit profileGit = response.body();
                mainActivityContract.returnGitProfile(profileGit);
                Log.d("TAG", "HERE");
            }

            @Override
            public void onFailure(Call<ProfileGit> call, Throwable t) {
                Log.e("TAG", t.getMessage());
            }

        });

    }
}
