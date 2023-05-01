package it.akaisara.backendtest.infrastructure.database;

import it.akaisara.backendtest.domain.model.Category;
import it.akaisara.backendtest.domain.model.Drink;
import it.akaisara.backendtest.domain.respository.DrinkRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DrinkRepositoryImpl implements DrinkRepository {

    private final CategoryDatabaseRepository categoryCrudRepository;
    private final DrinkDatabaseRepository drinkCrudRepository;

    public DrinkRepositoryImpl(CategoryDatabaseRepository categoryCrudRepository, DrinkDatabaseRepository drinkCrudRepository) {
        this.categoryCrudRepository = categoryCrudRepository;
        this.drinkCrudRepository = drinkCrudRepository;
    }

    public void createAllCategories(List<Category> categories) {
        categoryCrudRepository.saveAll(categories);
    }

    @Override
    public void createAllDrinks(List<Drink> drinks) {
        drinkCrudRepository.saveAll(drinks);
    }
}
