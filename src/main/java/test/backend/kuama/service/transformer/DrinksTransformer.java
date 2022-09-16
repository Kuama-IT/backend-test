package test.backend.kuama.service.transformer;

import static io.vavr.API.$;
import static io.vavr.API.Case;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import io.vavr.API;
import test.backend.kuama.dto.DrinkDto;
import test.backend.kuama.dto.DrinksResponseDto;
import test.backend.kuama.external.model.Drink;
import test.backend.kuama.external.model.Drinks;

public final class DrinksTransformer {

	public static DrinksResponseDto getDrinksResponseDtoFromDrinks(final Drinks drinks, final String language) {
		DrinksResponseDto drinksResponseDto = new DrinksResponseDto();
		drinksResponseDto.setDrinks(new ArrayList<>());
		drinks.getDrinks().forEach(drink -> {
			DrinkDto drinkDto = new DrinkDto();
			drinkDto.setGlass(drink.getStrGlass());
			drinkDto.setName(drink.getStrDrink());
			drinkDto.setInstructions(getInstructionFromLanguage(drink, language));
			drinkDto.setThumbnail(drink.getStrDrinkThumb());
			drinkDto.setIngredients(getAllIngredients(drink));
			drinksResponseDto.getDrinks().add(drinkDto);
		});
		return drinksResponseDto;
	}

	private static List<String> getAllIngredients(final Drink drink) {
		List<String> ingredients = new ArrayList<>();
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient1());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient2());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient3());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient4());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient5());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient6());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient7());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient8());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient9());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient10());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient11());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient12());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient13());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient14());
		CollectionUtils.addIgnoreNull(ingredients, drink.getStrIngredient15());

		return ingredients;
	}

	private static String getInstructionFromLanguage(final Drink drink, final String language) {
		return API
				.Match(language)
				.of(Case($("EN"), drink.getStrInstructions()),
						Case($("FR"),
								StringUtils.isEmpty(drink.getStrInstructionsFR()) ? drink.getStrInstructions()
										: drink.getStrInstructionsFR()),
						Case($("DE"),
								StringUtils.isEmpty(drink.getStrInstructionsDE()) ? drink.getStrInstructions()
										: drink.getStrInstructionsDE()),
						Case($("IT"),
								StringUtils.isEmpty(drink.getStrInstructionsIT()) ? drink.getStrInstructions()
										: drink.getStrInstructionsIT()),
						Case($("ES"), StringUtils.isEmpty(drink.getStrInstructionsES()) ? drink.getStrInstructions()
								: drink.getStrInstructionsES()));
	}
}
