package com.example.footballproject.Models.premierleague.plstanding;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Plstanding{

	@SerializedName("season")
	private Season season;

	@SerializedName("competition")
	private Competition competition;

	@SerializedName("filters")
	private Filters filters;

	@SerializedName("standings")
	private List<StandingsItem> standings;

	public void setSeason(Season season){
		this.season = season;
	}

	public Season getSeason(){
		return season;
	}

	public void setCompetition(Competition competition){
		this.competition = competition;
	}

	public Competition getCompetition(){
		return competition;
	}

	public void setFilters(Filters filters){
		this.filters = filters;
	}

	public Filters getFilters(){
		return filters;
	}

	public void setStandings(List<StandingsItem> standings){
		this.standings = standings;
	}

	public List<StandingsItem> getStandings(){
		return standings;
	}
}