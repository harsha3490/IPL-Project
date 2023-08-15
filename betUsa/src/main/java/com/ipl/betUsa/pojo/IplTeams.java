package com.ipl.betUsa.pojo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "IPL_TEAMS")
public class IplTeams implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int iplTeamId;
	
	private String name;
	private Integer iplYear;
	private String imgUrl;
	
	public IplTeams() {
		// TODO Auto-generated constructor stub
	}
	
	
	public IplTeams(int iplTeamId, String name, Integer iplYear, String imgUrl) {
		super();
		this.iplTeamId = iplTeamId;
		this.name = name;
		this.iplYear = iplYear;
		this.imgUrl = imgUrl;
	}



	public int getIplTeamId() {
		return iplTeamId;
	}

	public void setIplTeamId(int iplTeamId) {
		this.iplTeamId = iplTeamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIplYear() {
		return iplYear;
	}

	public void setIplYear(Integer iplYear) {
		this.iplYear = iplYear;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
}
