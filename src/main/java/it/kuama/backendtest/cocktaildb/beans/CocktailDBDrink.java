package it.kuama.backendtest.cocktaildb.beans;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import it.kuama.backendtest.cocktaildb.utils.CocktailDBDrinkDeserializer;

@JsonDeserialize(using = CocktailDBDrinkDeserializer.class)
public class CocktailDBDrink {

	protected String idDrink;
	
	protected String strDrink;
	
	protected String strDrinkThumb;
	
	protected String strCategory;
	
	protected String strGlass;
	
	protected List<String> ingredients;
	
	protected Map<String, String> instructions;
	
	public Map<String, String> getInstructions() {
		return instructions;
	}

	public void setInstructions(Map<String, String> instructions) {
		this.instructions = instructions;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public String getIdDrink() {
		return idDrink;
	}

	public void setIdDrink(String idDrink) {
		this.idDrink = idDrink;
	}

	public String getStrDrink() {
		return strDrink;
	}

	public void setStrDrink(String strDrink) {
		this.strDrink = strDrink;
	}

	public String getStrDrinkThumb() {
		return strDrinkThumb;
	}

	public void setStrDrinkThumb(String strDrinkThumb) {
		this.strDrinkThumb = strDrinkThumb;
	}

	public String getStrCategory() {
		return strCategory;
	}

	public void setStrCategory(String strCategory) {
		this.strCategory = strCategory;
	}

	public String getStrGlass() {
		return strGlass;
	}

	public void setStrGlass(String strGlass) {
		this.strGlass = strGlass;
	}

}
