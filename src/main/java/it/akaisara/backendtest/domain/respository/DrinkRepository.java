package it.akaisara.backendtest.domain.respository;

import it.akaisara.backendtest.domain.model.Category;
import it.akaisara.backendtest.domain.model.Drink;

import java.util.List;

public interface DrinkRepository {

    void createAllCategories(List<Category> categories);

    void createAllDrinks(List<Drink> drinks);
}
