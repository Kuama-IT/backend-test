package it.kuama.backendtest.cocktaildb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import it.kuama.backendtest.BackendTestConfiguration;
import it.kuama.backendtest.beans.Drink;
import it.kuama.backendtest.beans.DrinkCategory;
import it.kuama.backendtest.cocktaildb.beans.CocktailDBDrink;
import it.kuama.backendtest.cocktaildb.beans.CocktailDBResponse;
import it.kuama.backendtest.cocktaildb.utils.CocktailDBUtils;
import it.kuama.backendtest.service.DrinkServiceInterface;
import it.kuama.backendtest.service.RequestPersistanceService;

/**
 * 
 * Services for Drinks!
 * @author Pietro
 */
@Service
public class CocktailDBDrinkService implements DrinkServiceInterface {

	protected static final String COCKTAILDB_ENTITY_LIST_API_URL = "list.php?{contextParam}=list";

	protected static final String COCKTAILDB_FILTER_BY_CATEGORY_API_URL = "filter.php?c={categoryParam}";

	protected static final String COCKTAILDB_LOOKUP_DRINK_BY_ID_API_URL = "lookup.php?i={drinkId}";

	protected static final String COCKTAILDB_FILTER_BY_DRINK_NAME_API_URL = "search.php?s={drinkNameParam}";

	/**
	 * Using cocktailDb Rest template
	 */
	@Autowired
	@Qualifier(BackendTestConfiguration.COCKTAILDB_REST_TEMPLATE)
	private RestTemplate restTemplate;
	
	@Autowired
	private RequestPersistanceService persistanceService;
	
	/**
	 * @return all drinks categories as List {@link DrinkCategory}
	 * @see DrinkCategory
	 */
	@Override
	public List<DrinkCategory> retrieveCategories() {
		List<DrinkCategory> categories = null;
		
		// Http request using Spring
		CocktailDBResponse response = restTemplate.getForObject(COCKTAILDB_ENTITY_LIST_API_URL,
				CocktailDBResponse.class, "c");
		
		if (!CollectionUtils.isEmpty(response.getDrinks())) {
			
			// Convert to DrinkCategory
			categories = response.getDrinks().stream().map(sourceDrink -> {
				return CocktailDBUtils.convertToDrinkCategory(sourceDrink);
			}).collect(Collectors.toList());
			
			//Persist the request
			persistanceService.persistRequest("CATEGORIES" , categories);
		}
		
		return categories;
	}

	/**
	 * @return all drinks of type Shot as List of {@link Drink}
	 * @see Drink
	 */
	@Override
	public List<Drink> retrieveShotCategoryDrinks() {
		List<Drink> drinks = null;
		
		// Http request using Spring
		CocktailDBResponse response = restTemplate.getForObject(COCKTAILDB_FILTER_BY_CATEGORY_API_URL,
				CocktailDBResponse.class, "Shot");
		if (!CollectionUtils.isEmpty(response.getDrinks())) {
			/*
			 * Api Specs do not permit to retrieve drinks detail by category, so I am forced
			 * to use drinks ID to make many http requests (I really don't like this, causes
			 * performance issues)
			 * 
			 */
			
			drinks = response.getDrinks().stream().map(sourceDrink -> {
				CocktailDBResponse drinkDetailResponse = restTemplate.getForObject(
						COCKTAILDB_LOOKUP_DRINK_BY_ID_API_URL, CocktailDBResponse.class, sourceDrink.getIdDrink());

				CocktailDBDrink drinkDetail = null;
				if (drinkDetailResponse != null && !CollectionUtils.isEmpty(drinkDetailResponse.getDrinks())) {
					drinkDetail = drinkDetailResponse.getDrinks().get(0);
				}
				return CocktailDBUtils.convertToDrink(drinkDetail);
			}).collect(Collectors.toList());
			
			//Persist the request
			persistanceService.persistRequest("SHOTS" , drinks);
		}

		return drinks;
	}

	/**
	 * @return all drinks that give a results for the keyword spritz as List of
	 *         {@link Drink}
	 * @see Drink
	 */
	@Override
	public List<Drink> retrieveSpritzDrinks() {
		List<Drink> drinks = null;

		// Http request using Spring
		CocktailDBResponse response = restTemplate.getForObject(COCKTAILDB_FILTER_BY_DRINK_NAME_API_URL,
				CocktailDBResponse.class, "spritz");
		
		// Convert to Drink List
		if (response != null && !CollectionUtils.isEmpty(response.getDrinks())) {
			drinks = response.getDrinks().stream().map(sourceDrink -> {
				return CocktailDBUtils.convertToDrink(sourceDrink);
			}).collect(Collectors.toList());
			
			//Persist the request
			persistanceService.persistRequest("SPRITZ" , drinks);
		}

		
		return drinks;
	}

	/**
	 * @return the king of drinks according to me
	 * @see Drink
	 */
	@Override
	public Drink myFavoriteOne() {
		Drink drink = null;
		
		// Http request using Spring
		CocktailDBResponse response = restTemplate.getForObject(COCKTAILDB_LOOKUP_DRINK_BY_ID_API_URL,
				CocktailDBResponse.class, "11113");
		
		CocktailDBDrink drinkDetail = null;
		
		// Convert to Drink
		if (response != null && !CollectionUtils.isEmpty(response.getDrinks())) {
			drinkDetail = response.getDrinks().get(0);
			
			drink = CocktailDBUtils.convertToDrink(drinkDetail);
			
			//Persist the request
			persistanceService.persistRequest("MYFAVORITE" , drink);
		}

		
		return drink;
	}

}
