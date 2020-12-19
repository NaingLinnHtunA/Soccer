package com.example.footballproject.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballproject.MatchDetailActivity;

import com.example.footballproject.Models.premierleague.plmatches.MatchesItem;
import com.example.footballproject.R;
import com.example.footballproject.utils.Utils;

import java.util.List;

public class PlHomeMatchAdapter extends RecyclerView.Adapter<PlHomeMatchAdapter.PlMatchViewHolder> {
    private String team1_result,team2_result;

    private Context mContext;
    String competitionName;
    private List<MatchesItem> matchesItemList;

    public PlHomeMatchAdapter(Context mContext, List<MatchesItem> matchesItemList,String competitionName) {
        this.mContext = mContext;
        this.matchesItemList = matchesItemList;
        this.competitionName = competitionName;
    }


    @NonNull
    @Override
    public PlMatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.match_design,parent,false);
        return new PlMatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlMatchViewHolder holder, final int position) {


        holder.teamone.setText(matchesItemList.get(position).getHomeTeam().getName());
        String status = matchesItemList.get(position).getStatus();

        if (status.matches("FINISHED")){
           team1_result = matchesItemList.get(position).getScore().getFullTime().getHomeTeam()+"";
            team2_result = matchesItemList.get(position).getScore().getFullTime().getAwayTeam()+"";
            Log.d("Team result", team1_result);

            String str = "abcdefgh";
            Log.d("String",str.substring(0, 4));


            Log.d("Team1 Result", team1_result);



            holder.team1_result.setText( team1_result.substring(0, 1)+"    :");
            holder.team2_result.setText(team2_result.substring(0, 1)+"");
        }
        else if (status.matches("SCHEDULED")){
            holder.team1_result.setText(Utils.DateFormat(matchesItemList.get(position).getUtcDate()));
            holder.team2_result.setText("");
        }
        holder.teamtwo.setText(matchesItemList.get(position).getAwayTeam().getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, MatchDetailActivity.class);
                i.putExtra("teamid",matchesItemList.get(position).getHomeTeam().getId());
                i.putExtra("teamone",matchesItemList.get(position).getHomeTeam().getName());
                 i.putExtra("leagueName",competitionName);
                i.putExtra("matchDay",Utils.DateFormat(matchesItemList.get(position).getUtcDate()));
                i.putExtra("teamtwo",matchesItemList.get(position).getAwayTeam().getName());
                i.putExtra("date",Utils.DateToTimeFormat(matchesItemList.get(position).getUtcDate()));
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return matchesItemList.size();
    }

    public class PlMatchViewHolder extends RecyclerView.ViewHolder{
        TextView teamone,teamtwo,team1_result,team2_result;

        public PlMatchViewHolder(@NonNull View itemView) {
            super(itemView);
            teamone = itemView.findViewById(R.id.teamOne);
            teamtwo = itemView.findViewById(R.id.teamTwo);
            team1_result = itemView.findViewById(R.id.team1_result);
            team2_result = itemView.findViewById(R.id.team2_result);
        }
    }
}
