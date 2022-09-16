package test.backend.kuama.external;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import test.backend.kuama.exception.ExceptionFactory;
import test.backend.kuama.external.model.Drink;
import test.backend.kuama.external.model.Drinks;

@Service
public class CocktailRest {

	private final ExceptionFactory exceptionFactory = new ExceptionFactory();
	private final RestTemplate restTemplate = new RestTemplate();

	@Value("${cocktail.rest.baseUrl}")
	private String baseUrl;

	@Value("${cocktail.rest.apiKey}")
	private String key;

	@Value("${cocktail.rest.drinkCategories}")
	private String drinkCategories;

	@Value("${cocktail.rest.drinkByCategory}")
	private String drinksByCategory;

	@Value("${cocktail.rest.drinkByName}")
	private String drinksByName;

	@Value("${cocktail.rest.cocktailDetails}")
	private String cocktailDetails;

	public Drinks getAllDrinksCategories() {
		Drinks drinks = restTemplate.getForObject(baseUrl + key + drinkCategories, Drinks.class);

		if (drinks == null || drinks.getDrinks() == null) {
			throw exceptionFactory.notFound("Impossible to retrieve the categories");
		}

		return drinks;
	}

	public List<Integer> getAllIdDrinksByCategory(final String category) {
		Drinks drinks = restTemplate.getForObject(baseUrl + key + drinksByCategory + category, Drinks.class);

		if (drinks == null || drinks.getDrinks() == null) {
			throw exceptionFactory.notFound("Drinks not found for category: " + category);
		}

		return drinks.getDrinks().stream().map(Drink::getIdDrink).collect(Collectors.toList());
	}

	public Drinks getAllIdDrinksByName(final String name) {
		Drinks drinks = restTemplate.getForObject(baseUrl + key + drinksByName + name, Drinks.class);

		if (drinks == null || drinks.getDrinks() == null) {
			throw exceptionFactory.notFound("Drinks not found for name: " + name);
		}
		return drinks;
	}

	public Drink getFullCocktailDetailsById(final Integer id) {
		Drinks drinks = restTemplate.getForObject(baseUrl + key + cocktailDetails + id, Drinks.class);

		if (drinks == null || drinks.getDrinks() == null) {
			throw exceptionFactory.notFound("Impossible to retrieve the cocktail detail for id: " + id);
		}

		return drinks.getDrinks().get(0);
	}
}
