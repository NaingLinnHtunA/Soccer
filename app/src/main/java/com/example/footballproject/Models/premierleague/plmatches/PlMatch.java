package com.example.footballproject.Models.premierleague.plmatches;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class PlMatch{

	@SerializedName("count")
	private int count;

	@SerializedName("filters")
	private Filters filters;

	@SerializedName("matches")
	private List<MatchesItem> matches;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setFilters(Filters filters){
		this.filters = filters;
	}

	public Filters getFilters(){
		return filters;
	}

	public void setMatches(List<MatchesItem> matches){
		this.matches = matches;
	}

	public List<MatchesItem> getMatches(){
		return matches;
	}
}