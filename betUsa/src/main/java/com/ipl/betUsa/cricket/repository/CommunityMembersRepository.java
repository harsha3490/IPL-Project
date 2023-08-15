package com.ipl.betUsa.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipl.betUsa.pojo.CommunityMembers;

public interface CommunityMembersRepository extends JpaRepository<CommunityMembers, Integer> {
	
	CommunityMembers findByMemId(int id);

}
