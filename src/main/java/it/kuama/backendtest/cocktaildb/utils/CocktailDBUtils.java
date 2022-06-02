package it.kuama.backendtest.cocktaildb.utils;

import it.kuama.backendtest.beans.Drink;
import it.kuama.backendtest.beans.DrinkCategory;
import it.kuama.backendtest.cocktaildb.beans.CocktailDBDrink;

/**
 * 
 * Utility Class for CocktailDB
 * @author Pietro
 */
public class CocktailDBUtils {

	/**
	 * 
	 * @param {@link CocktailDBDrink} source
	 * @return {@link Drink}
	 */
	public static Drink convertToDrink(CocktailDBDrink source) {
		Drink drink = null;
		if (source != null) {
			drink = new Drink();
			drink.setName(source.getStrDrink());
			drink.setGlass(source.getStrGlass());
			drink.setThumbnail(source.getStrDrinkThumb());
			drink.setIngredients(source.getIngredients());
			drink.setInstructions(source.getInstructions());
		}
		return drink;
	}
	
	/**
	 * 
	 * @param {@link CocktailDBDrink} source
	 * @return {@link DrinkCategory}6
	 */
	public static DrinkCategory convertToDrinkCategory(CocktailDBDrink source) {
		DrinkCategory drinkCategory = null;
		if (source != null) {
			drinkCategory = new DrinkCategory();
			drinkCategory.setCategory(source.getStrCategory());
		}
		return drinkCategory;
	}

}
