package com.example.footballproject.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballproject.Adapters.PlMatchAdapter;
import com.example.footballproject.Api.ApiClient;
import com.example.footballproject.Api.ApiInterface;
import com.example.footballproject.Models.premierleague.plmatches.Competition;
import com.example.footballproject.Models.premierleague.plmatches.MatchesItem;
import com.example.footballproject.Models.premierleague.plmatches.PlMatch;
import com.example.footballproject.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchFragment extends Fragment {
    public static final String API_KEY="8387394b959644fc87b27c6a738d8e58";

    RecyclerView recyclerView;
    PlMatchAdapter plMatchAdapter;
    List<MatchesItem> matchesItemList = new ArrayList<>();
//    List<Competition> competitionList = new ArrayList<>();
    String competitionName;

    View rootView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.matches,container,false);

        recyclerView = rootView.findViewById(R.id.recyclerViewMatches);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        loadMatches();
        return rootView;
    }
    public void loadMatches(){

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<PlMatch> call;

        call = apiInterface.getMatches(API_KEY);

        call.enqueue(new Callback<PlMatch>() {
            @Override
            public void onResponse(Call<PlMatch> call, Response<PlMatch> response) {
                if (response.isSuccessful() && response.body().getMatches()!=null){
                    if (!matchesItemList.isEmpty()){
                        matchesItemList.clear();
                    }
//                    Log.d("data","okokokokok");
                    matchesItemList = response.body().getMatches();
                    //competitionName = response.body().getCompetition().getName();
                    plMatchAdapter = new PlMatchAdapter(getActivity(),matchesItemList,competitionName);
                    recyclerView.setAdapter(plMatchAdapter);
                    plMatchAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<PlMatch> call, Throwable t) {
                Log.d("errmsg",t.getMessage());
            }
        });

    }


}
