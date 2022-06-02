package it.kuama.backendtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.kuama.backendtest.beans.Drink;
import it.kuama.backendtest.beans.DrinkCategory;
import it.kuama.backendtest.service.DrinkServiceInterface;

@RestController
//If no implementation is found, API will be not available (404 on call)
@ConditionalOnBean(DrinkServiceInterface.class)
public class DrinksController {
	
	@Autowired
	protected DrinkServiceInterface drinkService;
	
	/**
	 * all drinks categories
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/categories")
	public List<DrinkCategory> categories() {
		return drinkService.retrieveCategories();
	}
	
	/**
	 * all drinks of type shot
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/shotDrinks")
	public List<Drink> shotDrinks() {
		return drinkService.retrieveShotCategoryDrinks();
	}
	
	/**
	 * all drinks that give a results for the keyword spritz.
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/spritzDrinks")
	public List<Drink> spritzDrinks() {
		return drinkService.retrieveSpritzDrinks();
	}
	
	/**
	 * yummy
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/someoneSaysImWeirdButIDontCareIlikeIt")
	public Drink someoneSaysImWeirdButIDontCareIlikeIt() {
		return drinkService.myFavoriteOne();
	}

}
