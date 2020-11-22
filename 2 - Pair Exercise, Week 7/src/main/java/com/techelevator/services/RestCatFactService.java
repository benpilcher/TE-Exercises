package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatFact;

@Component
public class RestCatFactService implements CatFactService {

	@Override
	public CatFact getFact() {
		CatFact catFact = new CatFact();
		RestTemplate restTemplate = new RestTemplate();
		catFact = restTemplate.getForObject("https://cat-fact.herokuapp.com/facts/random", CatFact.class);
		return catFact;
	}

}
