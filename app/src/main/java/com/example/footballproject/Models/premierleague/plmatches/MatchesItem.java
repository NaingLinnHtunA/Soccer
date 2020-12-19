package com.example.footballproject.Models.premierleague.plmatches;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class MatchesItem{

	@SerializedName("matchday")
	private int matchday;

	@SerializedName("awayTeam")
	private AwayTeam awayTeam;

	@SerializedName("competition")
	private Competition competition;

	@SerializedName("utcDate")
	private String utcDate;

	@SerializedName("lastUpdated")
	private String lastUpdated;

	@SerializedName("score")
	private Score score;

	@SerializedName("stage")
	private String stage;

	@SerializedName("season")
	private Season season;

	@SerializedName("homeTeam")
	private HomeTeam homeTeam;

	@SerializedName("id")
	private int id;

	@SerializedName("referees")
	private List<RefereesItem> referees;

	@SerializedName("status")
	private String status;

	@SerializedName("group")
	private String group;

	public void setMatchday(int matchday){
		this.matchday = matchday;
	}

	public int getMatchday(){
		return matchday;
	}

	public void setAwayTeam(AwayTeam awayTeam){
		this.awayTeam = awayTeam;
	}

	public AwayTeam getAwayTeam(){
		return awayTeam;
	}

	public void setCompetition(Competition competition){
		this.competition = competition;
	}

	public Competition getCompetition(){
		return competition;
	}

	public void setUtcDate(String utcDate){
		this.utcDate = utcDate;
	}

	public String getUtcDate(){
		return utcDate;
	}

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public void setScore(Score score){
		this.score = score;
	}

	public Score getScore(){
		return score;
	}

	public void setStage(String stage){
		this.stage = stage;
	}

	public String getStage(){
		return stage;
	}

	public void setSeason(Season season){
		this.season = season;
	}

	public Season getSeason(){
		return season;
	}

	public void setHomeTeam(HomeTeam homeTeam){
		this.homeTeam = homeTeam;
	}

	public HomeTeam getHomeTeam(){
		return homeTeam;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setReferees(List<RefereesItem> referees){
		this.referees = referees;
	}

	public List<RefereesItem> getReferees(){
		return referees;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setGroup(String group){
		this.group = group;
	}

	public String getGroup(){
		return group;
	}
}