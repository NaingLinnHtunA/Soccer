package com.example.footballproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.footballproject.Fragments.HeadtoheadFragment;
import com.example.footballproject.Fragments.LineupFragment;
import com.example.footballproject.Fragments.MatchFragment;
import com.example.footballproject.Fragments.MatchfactsFragment;
import com.example.footballproject.Fragments.TableFragment;
import com.google.android.material.tabs.TabLayout;

public class MatchDetailActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabAdapter tabAdapter;
    ViewPager viewPager;
    int teamId,matchDay,team1,team2;
    String leagueName,date,team1result,team2result;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Premier League");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_detail);

        TextView teamAway,team1_result,team2_result,teamHome;
        teamAway = findViewById(R.id.teamAway);
        team1_result = findViewById(R.id.team1_result);
        team2_result = findViewById(R.id.team2_result);
        teamHome = findViewById(R.id.teamHome);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){

                team1result = bundle.getString("team1result");
                team2result = bundle.getString("team2result");

                team1_result.setText(team1result);
                team2_result.setText(team2result);

                teamAway.setText(bundle.getString("teamone"));
                teamHome.setText(bundle.getString("teamtwo"));
                teamId = bundle.getInt("teamid");
                leagueName = bundle.getString("leagueName");
                date = bundle.getString("date");



        }

        Log.d("teamId", "onCreate: "+teamId);

        tabLayout = findViewById(R.id.detailTab);
        viewPager = findViewById(R.id.detailPager);

        tabAdapter = new TabAdapter(getSupportFragmentManager());

        Bundle fbundle = new Bundle();
        fbundle.putInt("teamId",teamId);
        fbundle.putString("team1result",team1result);
        fbundle.putString("team2result",team2result);
        fbundle.putString("leagueName",leagueName);
        fbundle.putString("date",date);

        MatchfactsFragment matchfactsFragment = new MatchfactsFragment();
        matchfactsFragment.setArguments(fbundle);

        tabAdapter.addFragment(matchfactsFragment,"MATCH FACTS",0);
        tabAdapter.addFragment(new LineupFragment(),"LINEUP",0);
        tabAdapter.addFragment(new TableFragment(),"Table",0);
        tabAdapter.addFragment(new HeadtoheadFragment(),"HEAD-TO-HEAD",0);

        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getSelectedTabPosition();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
