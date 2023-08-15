package com.ipl.betUsa.Request;

import java.io.Serializable;

public class BetRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int cricketMatchId;
	private int userId;
	private String teamSelected;
	private int teamId;
	
	public int getCricketMatchId() {
		return cricketMatchId;
	}
	public void setCricketMatchId(int cricketMatchId) {
		this.cricketMatchId = cricketMatchId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTeamSelected() {
		return teamSelected;
	}
	public void setTeamSelected(String teamSelected) {
		this.teamSelected = teamSelected;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
	

}
