package it.kuama.backendtest.cocktaildb.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import it.kuama.backendtest.cocktaildb.beans.CocktailDBDrink;

/**
 * Deserializer for a {@link CocktailDBDrink}. <p><b>Note: </b> this change original JSON structure of the response
 * @see CocktailDBDrink
 * */
public class CocktailDBDrinkDeserializer extends JsonDeserializer<CocktailDBDrink> {

	protected final static String STANDARD_LANGUAGE = "EN";
	
	protected final static String INSTRUCTIONS_FIELD_PREFIX = "strInstructions";
	
	protected final static String INGREDIENTS_FIELD_PREFIX = "strIngredient";
	
	/**
	 * Deserialize a {@link CocktailDBDrink}
	 * 
	 * <p>Drink Ingredients are stored in a List of {@link String}
	 * <p>Drink Instructions are stored in a Map. Language is key. 
	 * 
	 * @see CocktailDBDrink
	 * */
	@Override
	public CocktailDBDrink deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		CocktailDBDrink dr = new CocktailDBDrink();
		JsonNode node = p.getCodec().readTree(p);
		
		// Standard properties
		dr.setIdDrink(getProperty(node, "idDrink"));
		
		dr.setStrDrink(getProperty(node, "strDrink"));
		
		dr.setStrDrinkThumb(getProperty(node, "strDrinkThumb"));
		
		dr.setStrCategory(getProperty(node, "strCategory"));
		
		dr.setStrGlass(getProperty(node, "strGlass"));

		dr.setInstructions(new HashMap<>());
		
		TreeMap<Integer, String> orderableIngredientsMap = new TreeMap<Integer, String>();
		
		// For every json property
		Iterator<String> fieldIterator = node.fieldNames();
		while(fieldIterator.hasNext()) {
			String currentField = fieldIterator.next();
			
			// If an instruction
			// Language is now the key of instructions. Useful for supported languages checks
			if(currentField.startsWith(INSTRUCTIONS_FIELD_PREFIX)) {
				String language = currentField.replace(INSTRUCTIONS_FIELD_PREFIX,"");
				if(language == null || "".equals(language.trim())) {
					language = STANDARD_LANGUAGE;
				}
				if(!node.get(currentField).isNull()) {
					dr.getInstructions().put(language, node.get(currentField).asText());
				}
			}
			
			//If an ingredient
			// This mantains Ingredients order in the new list, and supports adding ingredients in the future	
			else if(currentField.startsWith(INGREDIENTS_FIELD_PREFIX)) {
				Integer ingredientIndex = null;
				String indexValue = currentField.substring(INGREDIENTS_FIELD_PREFIX.length());
				try {
					ingredientIndex = Integer.parseUnsignedInt(indexValue);
					if(!node.get(currentField).isNull()) {
						orderableIngredientsMap.put(ingredientIndex, node.get(currentField).asText());
					}
				} catch (NumberFormatException e) {
					// It's ok this is not a valid unsigned number, just ignore it
				}
			}
		}
		
		dr.setIngredients(new ArrayList<>(orderableIngredientsMap.values()));

		return dr;
	}
	
	// Just a nullsafe check. 
	private static String getProperty(JsonNode node, String propertyName) {
		return node.get(propertyName) != null ? node.get(propertyName).asText() : null;
	}

}
