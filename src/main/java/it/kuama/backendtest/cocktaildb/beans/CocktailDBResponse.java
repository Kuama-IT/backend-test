package it.kuama.backendtest.cocktaildb.beans;

import java.util.List;

public class CocktailDBResponse {

	protected List<CocktailDBDrink> drinks;

	public List<CocktailDBDrink> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<CocktailDBDrink> drinks) {
		this.drinks = drinks;
	}
	
}
