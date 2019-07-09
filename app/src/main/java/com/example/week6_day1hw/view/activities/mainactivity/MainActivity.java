package com.example.week6_day1hw.view.activities.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.week6_day1hw.R;
import com.example.week6_day1hw.model.datasource.gitpojo.ProfileGit;
import com.example.week6_day1hw.view.activities.gitrepoactivity.GitReposActivity;

public class MainActivity extends AppCompatActivity implements MainActivityContract {

    TextView tvUserName;
    TextView tvUserBio;
    TextView tvUserCompany;
    TextView tvUserLocation;
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvUserName = findViewById(R.id.tvUserName);
        tvUserBio = findViewById(R.id.tvUserBio);
        tvUserCompany = findViewById(R.id.tvUserCompany);
        tvUserLocation = findViewById(R.id.tvUserLocation);
        mainActivityPresenter = new MainActivityPresenter(this);
        mainActivityPresenter.getProfileGit();
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, GitReposActivity.class);
        startActivity(intent);
    }

    @Override
    public void returnGitProfile(ProfileGit profileGit) {
        tvUserName.setText(profileGit.getLogin());
        tvUserBio.setText(profileGit.getBio());
        tvUserCompany.setText(profileGit.getCompany());
        tvUserLocation.setText(profileGit.getLocation());
    }
}
