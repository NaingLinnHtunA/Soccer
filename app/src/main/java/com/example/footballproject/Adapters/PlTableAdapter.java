package com.example.footballproject.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.footballproject.Models.premierleague.plstanding.StandingsItem;

import com.example.footballproject.Models.premierleague.plstanding.TableItem;
import com.example.footballproject.R;

import java.util.List;

public class PlTableAdapter extends RecyclerView.Adapter<PlTableAdapter.PlTableViewHolder> {

    private Context mContext;
    private List<StandingsItem> standingsItemList;
    private List<TableItem> tableItemList;

    public PlTableAdapter(Context mContext, List<TableItem> tableItemList) {
        this.mContext = mContext;
        this.tableItemList = tableItemList;
    }

    @NonNull
    @Override
    public PlTableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.table_design,parent,false);
        return new PlTableViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PlTableViewHolder holder, int position) {
        holder.no.setText(Integer.toString(tableItemList.get(position).getPosition()));
        holder.team.setText(tableItemList.get(position).getTeam().getName());
        Glide.with(mContext).load(tableItemList.get(position).getTeam().getCrestUrl()).transition(DrawableTransitionOptions.withCrossFade()).into(holder.logo);
        holder.pl.setText(Integer.toString(tableItemList.get(position).getPlayedGames()));
        holder.w.setText(Integer.toString(tableItemList.get(position).getWon()));
        holder.d.setText(Integer.toString(tableItemList.get(position).getDraw()));
        holder.l.setText(Integer.toString(tableItemList.get(position).getLost()));
        holder.add.setText(Integer.toString(tableItemList.get(position).getGoalsFor()+tableItemList.get(position).getGoalsAgainst()));
        holder.gd.setText(Integer.toString(tableItemList.get(position).getGoalDifference()));
        holder.pts.setText(Integer.toString(tableItemList.get(position).getPoints()));


    }

    @Override
    public int getItemCount() {
        Log.d("Size", tableItemList.size()+"");
        return tableItemList.size();
    }
    public class PlTableViewHolder extends RecyclerView.ViewHolder{
        ImageView logo;
        TextView no,team,pl,w,d,l,add,gd,pts;
        public PlTableViewHolder(@NonNull View itemView) {
            super(itemView);
            no = itemView.findViewById(R.id.No);
            team = itemView.findViewById(R.id.team);
            logo = itemView.findViewById(R.id.logo);
            pl = itemView.findViewById(R.id.pl);
            w = itemView.findViewById(R.id.w);
            d = itemView.findViewById(R.id.d);
            l = itemView.findViewById(R.id.l);
            add = itemView.findViewById(R.id.add);
            gd = itemView.findViewById(R.id.gd);
            pts = itemView.findViewById(R.id.pts);
        }
    }
}
