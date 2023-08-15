package com.ipl.betUsa.controllerc.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipl.betUsa.cricket.repository.BetRepository;
import com.ipl.betUsa.cricket.repository.CommunityMembersRepository;
import com.ipl.betUsa.cricket.repository.CricketMatchDetailsRepository;
import com.ipl.betUsa.pojo.Bet;
import com.ipl.betUsa.pojo.BetStatus;
import com.ipl.betUsa.pojo.CommunityMembers;
import com.ipl.betUsa.pojo.CricketMatchDetails;

@Service
public class IplAdminService {
	
	@Autowired
	private CricketMatchDetailsRepository matchDetailsRepo;
	@Autowired
	private BetRepository betRepo;
	@Autowired
	private CommunityMembersRepository memRepo;
	
	
	@Transactional
	public void updateCricketMatchStatus(CricketMatchDetails matchDetails) {


		matchDetailsRepo.save(matchDetails);
		List<Bet> betList = betRepo.findByCricketMatch(matchDetails);
		List<CommunityMembers> memList = memRepo.findAll();
		List<Integer> memIds = new ArrayList<>();
		if(null != betList) {
			betList.stream().forEach(bet->{
				if(null != bet.getSelectedTeam()) {
					memIds.add(bet.getComm().getMemId());
					bet.setUpdatedDate(LocalDateTime.now());
					
						if(bet.getSelectedTeam().equalsIgnoreCase(matchDetails.getWinningTeam())) {
							bet.setBetStatus(BetStatus.WON);
						}
						else {
							bet.setBetStatus(BetStatus.LOSE);
						}
					
					betRepo.save(bet);
				}
			});
		}
		for(CommunityMembers mem : memList) {
			if(!memIds.contains(mem.getMemId())){
				Bet bet = null;
				bet = betRepo.findByCricketMatchAndComm(matchDetails, mem);
				if(null == bet) {
					bet = new Bet();
					bet.setBetStatus(BetStatus.NO_SELECTION);
					bet.setCreatedDate(LocalDateTime.now());
					bet.setComm(mem);
					bet.setCricketMatch(matchDetails);
					bet.setAmount(-matchDetails.getAmountForBet());
					betRepo.save(bet);
				}
				
			}
		}
	
	}

}
