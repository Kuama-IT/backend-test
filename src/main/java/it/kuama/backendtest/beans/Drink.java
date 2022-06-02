package it.kuama.backendtest.beans;

import java.util.List;
import java.util.Map;

/**
 * 
 * Drink class, showing the following information:
	<p>•name
	<p>•glass
	<p>•instructions
	<p>•ingredients
	<p>•thumbnail
	@author Pietro
 * */
public class Drink {

	protected String name;
	
	protected String glass;
	
	protected Map<String, String> instructions;
	
	protected List<String> ingredients;
	
	protected String thumbnail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGlass() {
		return glass;
	}

	public void setGlass(String glass) {
		this.glass = glass;
	}

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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
}
