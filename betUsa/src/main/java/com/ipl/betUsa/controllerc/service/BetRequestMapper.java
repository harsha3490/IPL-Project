package com.ipl.betUsa.controllerc.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ipl.betUsa.Request.BetRequest;
import com.ipl.betUsa.cricket.repository.BetRepository;
import com.ipl.betUsa.cricket.repository.CommunityMembersRepository;
import com.ipl.betUsa.cricket.repository.CricketMatchDetailsRepository;
import com.ipl.betUsa.pojo.Bet;
import com.ipl.betUsa.pojo.BetStatus;
import com.ipl.betUsa.pojo.CommunityMembers;
import com.ipl.betUsa.pojo.CricketMatchDetails;

@Service
public class BetRequestMapper {
	
	public BetRequestMapper() {
	}

	public List<Bet> createABet(List<BetRequest> betRequestList,CricketMatchDetailsRepository cricketMatchDetailsRepository,
			CommunityMembersRepository membersRepository, BetRepository betRepository) {
		List<Bet> betList = new ArrayList<>();
		for (BetRequest betRequest : betRequestList) {
			CricketMatchDetails matchDetails = cricketMatchDetailsRepository.findById(betRequest.getCricketMatchId());
			CommunityMembers communityMembers = membersRepository.findByMemId(betRequest.getUserId());
			Bet betExisting = betRepository.findByCricketMatchAndComm(matchDetails,communityMembers);
			Bet bet = null;
			if(null!=betExisting) {
				bet = betExisting;
				bet.setUpdatedDate(LocalDateTime.now());
			}
			else {
				bet = new Bet();
				bet.setCreatedDate(LocalDateTime.now());
			}
			bet.setSelectedTeam(betRequest.getTeamSelected());
			bet.setBetStatus(BetStatus.OPEN);
			bet.setCricketMatch(matchDetails);
			bet.setComm(membersRepository.findByMemId(betRequest.getUserId()));
			bet.setAmount(matchDetails.getAmountForBet());
			betList.add(bet);
		}
		return betList;
	}
	
}
