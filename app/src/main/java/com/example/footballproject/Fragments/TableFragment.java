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
import com.example.footballproject.Adapters.PlTableAdapter;
import com.example.footballproject.Api.ApiClient;
import com.example.footballproject.Api.ApiInterface;

import com.example.footballproject.Models.premierleague.plmatches.PlMatch;

import com.example.footballproject.Models.premierleague.plstanding.Plstanding;
import com.example.footballproject.Models.premierleague.plstanding.StandingsItem;
import com.example.footballproject.Models.premierleague.plstanding.TableItem;
import com.example.footballproject.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TableFragment extends Fragment {
    public static final String API_KEY="8387394b959644fc87b27c6a738d8e58";
    public static String Type;

    RecyclerView recyclerView;
    PlTableAdapter plTableAdapter;

    List<StandingsItem> standingsItemList = new ArrayList<>();
    List<TableItem> tableItemList = new ArrayList<>();



    View rootView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tables,container,false);

        recyclerView = rootView.findViewById(R.id.recyclerViewTables);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        loadTable();
        return rootView;
    }
    public void loadTable(){
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Plstanding> call;

        call = apiInterface.getStandings("TOTAL",API_KEY);

        call.enqueue(new Callback<Plstanding>() {
            @Override
            public void onResponse(Call<Plstanding> call, Response<Plstanding> response) {
                if (response.isSuccessful() && response.body().getStandings()!=null){
                    if (!standingsItemList.isEmpty()){
                        standingsItemList.clear();
                    }
//                    Log.d("data",response.body().getStandings().toString());
                    int i = 0;
                    tableItemList = response.body().getStandings().get(i).getTable();
                    Log.d("data",tableItemList.size()+"");
                    plTableAdapter = new PlTableAdapter(getActivity(),tableItemList);
                    recyclerView.setAdapter(plTableAdapter);
                    plTableAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<Plstanding> call, Throwable t) {
                Log.d("errmsg",t.getMessage());
            }
        });

    }
}
