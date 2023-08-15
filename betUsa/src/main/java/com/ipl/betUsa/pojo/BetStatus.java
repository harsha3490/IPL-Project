package com.ipl.betUsa.pojo;

public enum BetStatus {
	OPEN("Open"),
	CLOSED("Closed"),
	WON("Won"),
	LOSE("Lose"),
	SELECTED("Selected"),
	NO_SELECTION("No Selection");
	
	private String value;
	 
    public String getValue(){
        return this.value;
    }


	BetStatus(String value) {
		this.value = value;
	}
	
	
	
}
