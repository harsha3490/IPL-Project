package com.ipl.betUsa.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.betUsa.Exception.BetNotSavedException;
import com.ipl.betUsa.Request.BetRequest;
import com.ipl.betUsa.controllerc.service.BetRequestMapper;
import com.ipl.betUsa.cricket.repository.BetRepository;
import com.ipl.betUsa.cricket.repository.CommunityMembersRepository;
import com.ipl.betUsa.cricket.repository.CricketMatchDetailsRepository;
import com.ipl.betUsa.pojo.Bet;
import com.ipl.betUsa.pojo.CommunityMembers;
import com.ipl.betUsa.pojo.CricketMatchDetails;

@RestController
@RequestMapping(path = "/ipl/")


public class IplController {

	private CricketMatchDetailsRepository crickRepo;
	private BetRepository betRepository;
	private BetRequestMapper betRequestMapper;
	private CommunityMembersRepository membersRepository;
	
	public IplController(CricketMatchDetailsRepository iplRepository, 
			BetRepository betRepository, 
			CommunityMembersRepository membersRepository, 
			BetRequestMapper betRequestMapper) {
		this.crickRepo = iplRepository;
		this.betRepository = betRepository;
		this.betRequestMapper = betRequestMapper;
		this.membersRepository = membersRepository;
	}
	
	
	
	
	@GetMapping(path = "/{userId}/getIPLCurrentMatch")
	public List<CricketMatchDetails> getIPLCurrentMatchDetails(@PathVariable(name="userId", required = true) int userId) {
		  LocalDateTime currentTime = LocalDateTime.now();
		  LocalDateTime endTime = LocalDateTime.now().plusHours(23);
		  List<CricketMatchDetails> cricketMatchDetails = crickRepo.findByDateTimeOfMatch(currentTime,endTime);
		  final CommunityMembers mem = new CommunityMembers();
		  mem.setMemId(userId);
		  List<Bet> betDetails = betRepository.findByCricketMatchInAndComm(cricketMatchDetails, mem);
		  cricketMatchDetails.forEach(cric -> betDetails.forEach(bet -> {
			if (cric.getId() == bet.getCricketMatch().getId()) {
				cric.setTeamSelected(bet.getSelectedTeam());
			}
		}));
		  return cricketMatchDetails;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/getIPLMatchByMatchNo/{iplYear}/{id}")
	public CricketMatchDetails getIPLCurrentMatchDetails(@PathVariable(name="id") int id,
			@PathVariable(name="iplYear") int iplYear) {
		CricketMatchDetails  cricketMatchDetails =crickRepo.findByIplYearAndMatchNo(iplYear,id);
		return cricketMatchDetails;
	}
	
	@GetMapping(path = "/{iplYear}/getIplTeams")
	public List<String> getIplTeamsByYear(@PathVariable(name = "iplYear", required = true) int iplYear){
		List<String> iplTeams = crickRepo.findDistinctTeam1ByIplYear(iplYear);
		return iplTeams;
	}
	
	
	@GetMapping(path = "/getCurrentYearIPLMatches")
	public List<CricketMatchDetails> getCurrentYearIPLMatches(){
		List<CricketMatchDetails> allIplMatches = crickRepo.findByIplYear(LocalDate.now().getYear());
		return allIplMatches;
	}
	
	
	
	
	@GetMapping(path = "/{iplYear}/getIPLMatches")
	public List<CricketMatchDetails> getIPLMatches(@PathVariable(name="iplYear") int iplYear){
		List<CricketMatchDetails> iplMatches = crickRepo.findByIplYear(iplYear);
		return iplMatches;
	}
	
	@GetMapping(path = "/{userId}/getCurrentYearIPLMyBetDetails")
	public List<Bet> getMyIPLBetDetails(@PathVariable(name = "userId") int userId){
		List<Bet> betDetails = null;
		CommunityMembers members = new CommunityMembers();
		members.setMemId(userId);
		betDetails = betRepository.findByComm(members);
		return betDetails;
	}
	
	@PostMapping(path = "/bet")
	public List<Bet> saveMyBet(@RequestBody(required = true) List<BetRequest> betRequestList) {
		List<Bet> bets = null;
		try {
			bets = betRequestMapper.createABet(betRequestList, crickRepo, membersRepository, betRepository);
			for (Bet b : bets) {
				betRepository.save(b);
			}
		}
		catch(Exception e) {
			throw new BetNotSavedException("Exception Occured While Saving your Bet");
		}
		return bets;
	}
}
