package com.example.footballproject.Models.premierleague.plstandings;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class StandingsItem{

	@SerializedName("stage")
	private String stage;

	@SerializedName("type")
	private String type;

	@SerializedName("table")
	private List<TableItem> table;

	@SerializedName("group")
	private Object group;

	public void setStage(String stage){
		this.stage = stage;
	}

	public String getStage(){
		return stage;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTable(List<TableItem> table){
		this.table = table;
	}

	public List<TableItem> getTable(){
		return table;
	}

	public void setGroup(Object group){
		this.group = group;
	}

	public Object getGroup(){
		return group;
	}
}