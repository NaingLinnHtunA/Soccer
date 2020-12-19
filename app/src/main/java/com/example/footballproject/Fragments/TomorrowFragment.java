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

import com.example.footballproject.Adapters.PlHomeMatchAdapter;
import com.example.footballproject.Adapters.PlMatchAdapter;
import com.example.footballproject.Api.ApiClient;
import com.example.footballproject.Api.ApiInterface;

import com.example.footballproject.Models.premierleague.plmatches.MatchesItem;
import com.example.footballproject.Models.premierleague.plmatches.PlMatch;
import com.example.footballproject.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TomorrowFragment extends Fragment {
    public static final String API_KEY="8387394b959644fc87b27c6a738d8e58";
    RecyclerView recyclerView;
    PlMatchAdapter plMatchAdapter;
    List<MatchesItem> matchesItemList = new ArrayList<>();
    View rootView;
    String competitionName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.matches,container,false);

        recyclerView = rootView.findViewById(R.id.recyclerViewMatches);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        //Today date
        /*Date cDate = new Date();
        String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);*/

        //Yesterday date
        /*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        String fDate = dateFormat.format(cal.getTime());*/

        //Tomorrow date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,+1);
        String fDate = dateFormat.format(cal.getTime());

        loadMatches(fDate,fDate);
        return rootView;

    }

    public void loadMatches(final String fDate,final String cDate){

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<PlMatch> call;

        call = apiInterface.getHomeMatches("" ,fDate, fDate,API_KEY);
        Log.d("requests",call.request().toString());

        call.enqueue(new Callback<PlMatch>() {
            @Override
            public void onResponse(Call<PlMatch> call, Response<PlMatch> response) {

                if (response.isSuccessful() && response.body().getMatches()!=null){
                    if (!matchesItemList.isEmpty()){
                        matchesItemList.clear();
                    }

                    matchesItemList = response.body().getMatches();
                    //competitionName = response.body().getCompetition().getName();
                    Log.d("matches","Okkk");

                    plMatchAdapter = new PlMatchAdapter(getActivity(),matchesItemList,competitionName);
                    recyclerView.setAdapter(plMatchAdapter);
                    plMatchAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<PlMatch> call, Throwable t) {

            }
        });
    }
}
