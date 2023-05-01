package it.akaisara.backendtest.service;

import it.akaisara.backendtest.domain.model.Category;
import it.akaisara.backendtest.domain.model.Drink;
import it.akaisara.backendtest.domain.respository.DrinkRepository;
import it.akaisara.backendtest.infrastructure.externalApi.DrinkExternalApiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {

    private final DrinkExternalApiService drinkExternalApiService;

    private final DrinkRepository drinkRepository;

    public DrinkServiceImpl(DrinkExternalApiService drinkExternalApiService, DrinkRepository drinkRepository) {
        this.drinkExternalApiService = drinkExternalApiService;
        this.drinkRepository = drinkRepository;
    }

    @Override
    public List<Category> getAllDrinkCategories() {
        List<Category> allDrinkCategories = drinkExternalApiService.getAllDrinkCategories();

        if (!allDrinkCategories.isEmpty()) {
            drinkRepository.createAllCategories(allDrinkCategories);
        }

        return allDrinkCategories;
    }

    @Override
    public List<Drink> getAllDrinksByCategory(Category category){
        List<Drink> allDrinksByCategory = drinkExternalApiService.getAllDrinksByCategory(category);

        if (!allDrinksByCategory.isEmpty()) {
            drinkRepository.createAllDrinks(allDrinksByCategory);
        }
        
        return allDrinksByCategory;
    }

    @Override
    public List<Drink> getAllDrinksWithSpecificKeywordName(Drink drinkWithSpecificName) {
        List<Drink> allDrinksWithSpecificName =
                drinkExternalApiService.getAllDrinksWithSpecificKeywordName(drinkWithSpecificName);

        if (!allDrinksWithSpecificName.isEmpty()) {
            drinkRepository.createAllDrinks(allDrinksWithSpecificName);
        }

        return allDrinksWithSpecificName;
    }
}
