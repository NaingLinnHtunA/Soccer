package com.example.footballproject.Models.premierleague.plstandings;


import com.google.gson.annotations.SerializedName;


public class TableItem{

	@SerializedName("goalsFor")
	private int goalsFor;

	@SerializedName("lost")
	private int lost;

	@SerializedName("won")
	private int won;

	@SerializedName("playedGames")
	private int playedGames;

	@SerializedName("position")
	private int position;

	@SerializedName("team")
	private Team team;

	@SerializedName("draw")
	private int draw;

	@SerializedName("goalsAgainst")
	private int goalsAgainst;

	@SerializedName("goalDifference")
	private int goalDifference;

	@SerializedName("points")
	private int points;

	public void setGoalsFor(int goalsFor){
		this.goalsFor = goalsFor;
	}

	public int getGoalsFor(){
		return goalsFor;
	}

	public void setLost(int lost){
		this.lost = lost;
	}

	public int getLost(){
		return lost;
	}

	public void setWon(int won){
		this.won = won;
	}

	public int getWon(){
		return won;
	}

	public void setPlayedGames(int playedGames){
		this.playedGames = playedGames;
	}

	public int getPlayedGames(){
		return playedGames;
	}

	public void setPosition(int position){
		this.position = position;
	}

	public int getPosition(){
		return position;
	}

	public void setTeam(Team team){
		this.team = team;
	}

	public Team getTeam(){
		return team;
	}

	public void setDraw(int draw){
		this.draw = draw;
	}

	public int getDraw(){
		return draw;
	}

	public void setGoalsAgainst(int goalsAgainst){
		this.goalsAgainst = goalsAgainst;
	}

	public int getGoalsAgainst(){
		return goalsAgainst;
	}

	public void setGoalDifference(int goalDifference){
		this.goalDifference = goalDifference;
	}

	public int getGoalDifference(){
		return goalDifference;
	}

	public void setPoints(int points){
		this.points = points;
	}

	public int getPoints(){
		return points;
	}
}