package com.example.footballproject.Models.premierleague.team;

import com.google.gson.annotations.SerializedName;

public class SquadItem{

	@SerializedName("role")
	private String role;

	@SerializedName("nationality")
	private String nationality;

	@SerializedName("countryOfBirth")
	private String countryOfBirth;

	@SerializedName("shirtNumber")
	private Object shirtNumber;

	@SerializedName("name")
	private String name;

	@SerializedName("dateOfBirth")
	private String dateOfBirth;

	@SerializedName("id")
	private int id;

	@SerializedName("position")
	private String position;

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}

	public void setNationality(String nationality){
		this.nationality = nationality;
	}

	public String getNationality(){
		return nationality;
	}

	public void setCountryOfBirth(String countryOfBirth){
		this.countryOfBirth = countryOfBirth;
	}

	public String getCountryOfBirth(){
		return countryOfBirth;
	}

	public void setShirtNumber(Object shirtNumber){
		this.shirtNumber = shirtNumber;
	}

	public Object getShirtNumber(){
		return shirtNumber;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDateOfBirth(String dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirth(){
		return dateOfBirth;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPosition(String position){
		this.position = position;
	}

	public String getPosition(){
		return position;
	}
}