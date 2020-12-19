package com.example.footballproject.Models.premierleague.plmatches;


import com.google.gson.annotations.SerializedName;


public class RefereesItem{

	@SerializedName("nationality")
	private Object nationality;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public void setNationality(Object nationality){
		this.nationality = nationality;
	}

	public Object getNationality(){
		return nationality;
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