package com.ipl.betUsa.pojo;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;


@Embeddable
@Entity
@Table(name = "BET")
public class Bet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer betID;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@PrimaryKeyJoinColumn
	private CricketMatchDetails cricketMatch;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private CommunityMembers comm;
	
	private String selectedTeam;
	private BetStatus betStatus;
	private Double amount;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
	public Bet() {
	}

	public Bet(Integer betID, CricketMatchDetails cricketMatch, CommunityMembers comm, String selectedTeam,
			BetStatus betStatus, Double amount, LocalDateTime createdDate, LocalDateTime updatedDate) {
		super();
		this.betID = betID;
		this.cricketMatch = cricketMatch;
		this.comm = comm;
		this.selectedTeam = selectedTeam;
		this.betStatus = betStatus;
		this.amount = amount;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getBetID() {
		return betID;
	}

	public void setBetID(Integer betID) {
		this.betID = betID;
	}

	public CricketMatchDetails getCricketMatch() {
		return cricketMatch;
	}

	public void setCricketMatch(CricketMatchDetails cricketMatch) {
		this.cricketMatch = cricketMatch;
	}

	public CommunityMembers getComm() {
		return comm;
	}

	public void setComm(CommunityMembers comm) {
		this.comm = comm;
	}

	public String getSelectedTeam() {
		return selectedTeam;
	}

	public void setSelectedTeam(String selectedTeam) {
		this.selectedTeam = selectedTeam;
	}

	public BetStatus getBetStatus() {
		return betStatus;
	}

	public void setBetStatus(BetStatus betStatus) {
		this.betStatus = betStatus;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

}
