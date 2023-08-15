package com.ipl.betUsa.cricket.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipl.betUsa.pojo.CricketMatchDetails;

@Repository
public interface CricketMatchDetailsRepository extends JpaRepository<CricketMatchDetails, Integer>  {

		  CricketMatchDetails findByIplYearAndMatchNo(int iplYear, int id);
	
		  List<CricketMatchDetails> findByDateTimeOfMatch(
		  LocalDateTime dateTime);
		 
		  //SELECT * FROM CRICKET_MATCH_DETAILS WHERE DATE_TIME_OF_MATCH BETWEEN NOW() 
		  //AND TIMESTAMPADD(HOUR,23,NOW()) AND CUT_OFF_TIME_FOR_MATCH>NOW();

		  @Query("select a from CricketMatchDetails a where a.dateTimeOfMatch between :startTime and :endTime and a.cutOffTimeForMatch>:startTime")
		  List<CricketMatchDetails> findByDateTimeOfMatch(@Param("startTime")
				  LocalDateTime startTime,@Param("endTime") LocalDateTime endTime);

		  @Query("select distinct a.team1 from CricketMatchDetails a where a.iplYear=:iplYear")
		  List<String> findDistinctTeam1ByIplYear(@Param("iplYear") int iplYear);

		List<CricketMatchDetails> findByIplYear(int year);
		
		CricketMatchDetails findById(int id);
	  
}
