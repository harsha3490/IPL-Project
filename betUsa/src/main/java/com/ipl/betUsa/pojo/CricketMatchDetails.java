package com.ipl.betUsa.pojo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;


@Entity
public class CricketMatchDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int matchNo;
	private int iplYear;
	private int matchDay;
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
	private LocalDateTime dateTimeOfMatch; 
	private String team1; 
	@Transient
	private String team1Logo;
	private String team2; 
	@Transient
	private String team2Logo;
	private String venue; 
	private String matchStatus;
	private String winningTeam;
	private LocalDateTime cutOffTimeForMatch;
	@NotNull(message = "Amount Can't be Null")
	private Double amountForBet;
	@Transient
	private String teamSelected;
	
	
	
	
	public LocalDateTime getCutOffTimeForMatch() {
		return cutOffTimeForMatch;
	}

	public void setCutOffTimeForMatch(LocalDateTime cutOffTimeForMatch) {
		this.cutOffTimeForMatch = cutOffTimeForMatch;
	}

	public Double getAmountForBet() {
		return amountForBet;
	}

	public void setAmountForBet(Double amountForBet) {
		this.amountForBet = amountForBet;
	}

	public CricketMatchDetails() {
	}
	
	public CricketMatchDetails(int matchNo, int iplYear, int matchDay, LocalDateTime dateTimeOfMatch, String team1, String team2,
			String venue, String matchStatus, String winningTeam,
			String team1Logo, String team2Logo) {
		super();
		this.matchNo = matchNo;
		this.matchDay = matchDay;
		this.dateTimeOfMatch = dateTimeOfMatch;
		this.team1 = team1;
		this.team2 = team2;
		this.venue = venue;
		this.matchStatus = matchStatus;
		this.winningTeam = winningTeam;
		this.iplYear = iplYear;
		this.team1Logo = team1Logo;
		this.team2Logo = team2Logo;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateTimeOfMatch() {
		return dateTimeOfMatch;
	}

	public void setDateTimeOfMatch(LocalDateTime dateTimeOfMatch) {
		this.dateTimeOfMatch = dateTimeOfMatch;
	}

	public String getTeamSelected() {
		return teamSelected;
	}

	public void setTeamSelected(String teamSelected) {
		this.teamSelected = teamSelected;
	}

	public int getMatchNo() {
		return matchNo;
	}
	public void setMatchNo(int matchNo) {
		this.matchNo = matchNo;
	}
	public int getMatchDay() {
		return matchDay;
	}
	public void setMatchDay(int matchDay) {
		this.matchDay = matchDay;
	}

	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getWinningTeam() {
		return winningTeam;
	}
	public void setWinningTeam(String winningTeam) {
		this.winningTeam = winningTeam;
	}
	public String getMatchStatus() {
		return matchStatus;
	}
	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}

	public int getIplYear() {
		return iplYear;
	}

	public void setIplYear(int iplYear) {
		this.iplYear = iplYear;
	}

	public String getTeam1Logo() {
		return team1Logo;
	}

	public void setTeam1Logo(String team1Logo) {
		this.team1Logo = team1Logo;
	}

	public String getTeam2Logo() {
		return team2Logo;
	}

	public void setTeam2Logo(String team2Logo) {
		this.team2Logo = team2Logo;
	}
	
	

}

