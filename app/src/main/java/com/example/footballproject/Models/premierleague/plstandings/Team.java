package com.example.footballproject.Models.premierleague.plstandings;


import com.google.gson.annotations.SerializedName;


public class Team{

	@SerializedName("crestUrl")
	private String crestUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public void setCrestUrl(String crestUrl){
		this.crestUrl = crestUrl;
	}

	public String getCrestUrl(){
		return crestUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}