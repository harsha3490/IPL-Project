package com.ipl.betUsa.pojo.request;

public class IplBetRequest {

	private int matchNo;
	private int userId;
	private String selectedTeam;
	
	public IplBetRequest() {
	}
	
	public IplBetRequest(int matchNo, int userId, String selectedTeam) {
		super();
		this.matchNo = matchNo;
		this.userId = userId;
		this.selectedTeam = selectedTeam;
	}

	public int getMatchNo() {
		return matchNo;
	}

	public void setMatchNo(int matchNo) {
		this.matchNo = matchNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSelectedTeam() {
		return selectedTeam;
	}

	public void setSelectedTeam(String selectedTeam) {
		this.selectedTeam = selectedTeam;
	}
	
	
	
	
}
