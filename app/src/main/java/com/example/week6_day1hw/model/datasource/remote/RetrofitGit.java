package com.example.week6_day1hw.model.datasource.remote;

import com.example.week6_day1hw.model.datasource.gitpojo.ProfileGit;
import com.example.week6_day1hw.model.datasource.gitpojo.RepoObject;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class RetrofitGit {
    //COME BACK TO THIS IF THERE ARE ISSUES
    public static final String BASE_URL = "https://api.github.com/";

    public Retrofit getRetroFitInstance(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)).build();

        return new Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public GitApiService getService(){
        return getRetroFitInstance().create(GitApiService.class);
    }

    public interface GitApiService{
        @GET
        Call<ProfileGit> getGitObject(@Url String api_url);

        @GET
        Call<RepoObject[]> getGitRepos(@Url String api_url);
    }
}
