package com.techelevator.controller;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardDAO;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import com.techelevator.services.RestCatFactService;
import com.techelevator.services.RestCatPicService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CatController {

    private CatCardDAO catCardDao;
    private RestCatFactService restCatFactService;
    private CatPicService catPicService;

    public CatController(CatCardDAO catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.restCatFactService = restCatFactService;
        this.catPicService = catPicService;
    }
    
    
    @RequestMapping(path = "/api/cards", method = RequestMethod.GET)
    public List<CatCard> list() {
    	return catCardDao.list();
    }
    
    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.GET)
    public CatCard get(@PathVariable long catCardId) throws CatCardNotFoundException {
    	return catCardDao.get(catCardId);
    }
    
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/api/cards", method = RequestMethod.POST)
    public boolean save(@Valid @RequestBody CatCard cardToSave) throws CatCardNotFoundException {
    	catCardDao.save(cardToSave);
    	return true;
    }

    
    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.PUT)
   public boolean update(@PathVariable long catCardId, @Valid @RequestBody CatCard card) throws  CatCardNotFoundException {
    	catCardDao.update(catCardId, card);
    	return true;
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable long catCardId) throws  CatCardNotFoundException {
    	catCardDao.delete(catCardId);
    	return true;
    }
    
    
	@RequestMapping(path = "/api/cards/random", method = RequestMethod.GET)
    public CatCard random() {
    	CatCard catCard = new CatCard();
    	RestCatFactService restCatFactService = new RestCatFactService();
    	
    	catCard.setCatFact(restCatFactService.getFact().getText());
    	RestCatPicService restCatPicsService = new RestCatPicService();
    	catCard.setImgUrl(restCatPicsService.getPic().getFile());
    	
        return catCard;
		
	}
    
    

    	
    }
    
   


