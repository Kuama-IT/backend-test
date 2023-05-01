package it.akaisara.backendtest.service;

import it.akaisara.backendtest.domain.model.Category;
import it.akaisara.backendtest.domain.model.Drink;

import java.util.List;

public interface DrinkService {
    public List<Category> getAllDrinkCategories();
    public List<Drink> getAllDrinksByCategory(Category category);
    public List<Drink> getAllDrinksWithSpecificKeywordName(Drink drinkWithSpecificName);
}
