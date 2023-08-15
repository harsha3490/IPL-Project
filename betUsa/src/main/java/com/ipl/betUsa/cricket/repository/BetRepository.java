package com.ipl.betUsa.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipl.betUsa.pojo.Bet;
import com.ipl.betUsa.pojo.CommunityMembers;
import com.ipl.betUsa.pojo.CricketMatchDetails;

@Repository
public interface BetRepository extends JpaRepository<Bet, Integer> {

	List<Bet> findByCricketMatchIn(List<CricketMatchDetails> cricketMatches);
	
	List<Bet> findByCricketMatch(CricketMatchDetails cricketMatches);


	List<Bet> findByComm(CommunityMembers members);

	List<Bet> findByCricketMatchInAndComm(List<CricketMatchDetails> cricketMatchDetails, CommunityMembers communityMembers);
	
	
	Bet findByCricketMatchAndComm(CricketMatchDetails cricketMatchDetails, CommunityMembers communityMembers);

}
