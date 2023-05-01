package it.akaisara.backendtest.service;

import it.akaisara.backendtest.domain.model.Category;
import it.akaisara.backendtest.domain.model.Drink;
import it.akaisara.backendtest.infrastructure.externalApi.DrinkExternalApiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {

    private final DrinkExternalApiService drinkExternalApiService;

    public DrinkServiceImpl(DrinkExternalApiService drinkExternalApiService) {
        this.drinkExternalApiService = drinkExternalApiService;
    }

    @Override
    public List<Category> getAllDrinkCategories() {
        return drinkExternalApiService.getAllDrinkCategories();
    }

    @Override
    public List<Drink> getAllDrinksByCategory(Category category){
        return drinkExternalApiService.getAllDrinksByCategory(category);
    }

    @Override
    public List<Drink> getAllDrinksWithSpecificKeywordName(Drink drinkWithSpecificName) {
        return drinkExternalApiService.getAllDrinksWithSpecificKeywordName(drinkWithSpecificName);
    }
}
