package it.kuama.backendtest.service;

import java.util.List;

import it.kuama.backendtest.beans.Drink;
import it.kuama.backendtest.beans.DrinkCategory;

public interface DrinkServiceInterface {
	
	List<DrinkCategory> retrieveCategories();
	
	List<Drink> retrieveShotCategoryDrinks();
	
	List<Drink> retrieveSpritzDrinks();
	
	Drink myFavoriteOne();

}
