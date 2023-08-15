package com.ipl.betUsa;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import com.ipl.betUsa.pojo.CricketMatchDetails;

public class TestingClass {
	
	public static void main(String[] args) throws URISyntaxException {
		TestingClass test = new TestingClass();
		test.getIplMatches();
	}
	
	public void getIplMatches() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("harsha", "harsha"));
		URI uri = new URI("https://golden-rush-373102.uk.r.appspot.com/ipl/getCurrentYearIPLMatches");
		List<CricketMatchDetails> details = 
				(List<CricketMatchDetails>) restTemplate.exchange(uri,
						org.springframework.http.HttpMethod.GET,
						null,ArrayList.class);
		
		
		
		
	}

}
