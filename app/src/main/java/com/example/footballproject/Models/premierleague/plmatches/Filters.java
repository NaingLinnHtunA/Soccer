package com.example.footballproject.Models.premierleague.plmatches;


import com.google.gson.annotations.SerializedName;


public class Filters{

	@SerializedName("dateTo")
	private String dateTo;

	@SerializedName("permission")
	private String permission;

	@SerializedName("dateFrom")
	private String dateFrom;

	public void setDateTo(String dateTo){
		this.dateTo = dateTo;
	}

	public String getDateTo(){
		return dateTo;
	}

	public void setPermission(String permission){
		this.permission = permission;
	}

	public String getPermission(){
		return permission;
	}

	public void setDateFrom(String dateFrom){
		this.dateFrom = dateFrom;
	}

	public String getDateFrom(){
		return dateFrom;
	}
}