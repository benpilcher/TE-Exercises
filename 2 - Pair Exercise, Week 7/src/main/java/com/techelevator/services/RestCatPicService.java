package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatPic;

@Component
public class RestCatPicService implements CatPicService {

	@Override
	public CatPic getPic() {
	RestTemplate restTemplate = new RestTemplate();
	CatPic catPic = restTemplate.getForObject("https://random-cat-image.herokuapp.com/", CatPic.class);
		return catPic;
	}

}	
