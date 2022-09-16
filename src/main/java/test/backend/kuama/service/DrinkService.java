package test.backend.kuama.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import test.backend.kuama.dto.DrinksResponseDto;
import test.backend.kuama.external.CocktailRest;
import test.backend.kuama.external.model.Drink;
import test.backend.kuama.external.model.Drinks;
import test.backend.kuama.persistence.repository.DrinkRepository;
import test.backend.kuama.persistence.transformer.DrinkTransformer;
import test.backend.kuama.service.transformer.DrinksTransformer;

@Service
@Slf4j
@RequiredArgsConstructor
public class DrinkService {
	private final CocktailRest cocktailRest;
	private final DrinkRepository drinkRepository;
	private final DrinkTransformer drinkTransformer;

	public DrinksResponseDto getAllDrinksByName(String name, String language) {
		DrinksResponseDto drinksResponseDto = DrinksTransformer
				.getDrinksResponseDtoFromDrinks(cocktailRest.getAllIdDrinksByName(name), language);
		drinkRepository.saveAll(drinkTransformer.getDrinkItem(drinksResponseDto.getDrinks()));

		return drinksResponseDto;
	}

	public DrinksResponseDto getAllDrinksByCategory(String category, String language) {
		List<Integer> idDrinks = cocktailRest.getAllIdDrinksByCategory(category);
		Drinks drinks = new Drinks();
		drinks.setDrinks(new ArrayList<>());

		idDrinks.forEach(id -> {
			Drink drink = cocktailRest.getFullCocktailDetailsById(id);
			drinks.getDrinks().add(drink);
		});

		DrinksResponseDto drinksResponseDto = DrinksTransformer.getDrinksResponseDtoFromDrinks(drinks, language);

		drinkRepository.saveAll(drinkTransformer.getDrinkItem(drinksResponseDto.getDrinks()));

		return drinksResponseDto;
	}
}
