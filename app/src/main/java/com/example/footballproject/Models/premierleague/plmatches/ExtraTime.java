package com.example.footballproject.Models.premierleague.plmatches;


import com.google.gson.annotations.SerializedName;


public class ExtraTime{

	@SerializedName("awayTeam")
	private Object awayTeam;

	@SerializedName("homeTeam")
	private Object homeTeam;

	public void setAwayTeam(Object awayTeam){
		this.awayTeam = awayTeam;
	}

	public Object getAwayTeam(){
		return awayTeam;
	}

	public void setHomeTeam(Object homeTeam){
		this.homeTeam = homeTeam;
	}

	public Object getHomeTeam(){
		return homeTeam;
	}
}