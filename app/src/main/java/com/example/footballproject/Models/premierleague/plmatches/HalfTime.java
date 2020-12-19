package com.example.footballproject.Models.premierleague.plmatches;


import com.google.gson.annotations.SerializedName;


public class HalfTime{

	@SerializedName("awayTeam")
	private int awayTeam;

	@SerializedName("homeTeam")
	private int homeTeam;

	public void setAwayTeam(int awayTeam){
		this.awayTeam = awayTeam;
	}

	public int getAwayTeam(){
		return awayTeam;
	}

	public void setHomeTeam(int homeTeam){
		this.homeTeam = homeTeam;
	}

	public int getHomeTeam(){
		return homeTeam;
	}
}