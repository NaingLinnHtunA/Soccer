package com.example.footballproject.Models.premierleague.plmatches;


import com.google.gson.annotations.SerializedName;


public class Score{

	@SerializedName("duration")
	private String duration;

	@SerializedName("winner")
	private String winner;

	@SerializedName("penalties")
	private Penalties penalties;

	@SerializedName("halfTime")
	private HalfTime halfTime;

	@SerializedName("fullTime")
	private FullTime fullTime;

	@SerializedName("extraTime")
	private ExtraTime extraTime;

	public void setDuration(String duration){
		this.duration = duration;
	}

	public String getDuration(){
		return duration;
	}

	public void setWinner(String winner){
		this.winner = winner;
	}

	public String getWinner(){
		return winner;
	}

	public void setPenalties(Penalties penalties){
		this.penalties = penalties;
	}

	public Penalties getPenalties(){
		return penalties;
	}

	public void setHalfTime(HalfTime halfTime){
		this.halfTime = halfTime;
	}

	public HalfTime getHalfTime(){
		return halfTime;
	}

	public void setFullTime(FullTime fullTime){
		this.fullTime = fullTime;
	}

	public FullTime getFullTime(){
		return fullTime;
	}

	public void setExtraTime(ExtraTime extraTime){
		this.extraTime = extraTime;
	}

	public ExtraTime getExtraTime(){
		return extraTime;
	}
}