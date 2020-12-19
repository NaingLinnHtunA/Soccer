package com.example.footballproject.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.footballproject.Adapters.PlMatchAdapter;
import com.example.footballproject.Api.ApiClient;
import com.example.footballproject.Api.ApiInterface;
import com.example.footballproject.Models.premierleague.plmatches.MatchesItem;
import com.example.footballproject.Models.premierleague.plmatches.PlMatch;
import com.example.footballproject.Models.premierleague.plstanding.Team;
import com.example.footballproject.Models.premierleague.team.TeamDetail;
import com.example.footballproject.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.footballproject.Fragments.MatchFragment.API_KEY;

public class MatchfactsFragment extends Fragment {
    TextView date,torunament,studium;
    View rootView;
    int teamId,matchDay;
    String leagueName,matchDate,team1result,team2result;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.match_facts,container,false);

        Bundle bundle = this.getArguments();
        teamId = bundle.getInt("teamId");
        team1result = bundle.getString("team1result");
        team2result = bundle.getString("team2result");
        leagueName = bundle.getString("leagueName");
        matchDate = bundle.getString("date");

        Log.d("matchIdInFragment", "match ID Fragment: "+teamId);

        date=rootView.findViewById(R.id.date);
        torunament=rootView.findViewById(R.id.torunament2);
        studium= rootView.findViewById(R.id.studium2);

        loadTeam(teamId);

        date.setText(matchDate);
        Log.d("date","date"+torunament);
        torunament.setText(leagueName + " round "+ matchDay);

        return rootView;
    }
    public void loadTeam(int teamId){

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<TeamDetail> call;

        call = apiInterface.getTeamDetail(teamId,API_KEY);

        call.enqueue(new Callback<TeamDetail>() {
            @Override
            public void onResponse(Call<TeamDetail> call, Response<TeamDetail> response) {
                if (response.isSuccessful() && response.body().getVenue()!=null){
                    studium.setText(response.body().getVenue());
                }
            }

            @Override
            public void onFailure(Call<TeamDetail> call, Throwable t) {
                Log.d("errmsg",t.getMessage());
            }
        });

    }




}
