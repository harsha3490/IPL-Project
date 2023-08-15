package com.ipl.betUsa.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.betUsa.controllerc.service.IplAdminService;
import com.ipl.betUsa.pojo.CricketMatchDetails;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/iplAdmin/")
public class IplAdminController {
	
	
	@Autowired
	private IplAdminService adminService;

	
	@PostMapping("/updateMatchStatus")
	public void updateMatchStatus(@Valid @RequestBody CricketMatchDetails matchDetails) throws Exception {
		if(LocalDateTime.now().isAfter(matchDetails.getDateTimeOfMatch())) {
			adminService.updateCricketMatchStatus(matchDetails);
		}
		else {
			throw new Exception("Either Match in Progress / Not Yet Started..!");
		}
		
	}
}
