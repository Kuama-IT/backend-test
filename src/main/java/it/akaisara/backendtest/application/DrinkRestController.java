package it.akaisara.backendtest.application;

import it.akaisara.backendtest.domain.model.Category;
import it.akaisara.backendtest.domain.model.Drink;
import it.akaisara.backendtest.service.DrinkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/80sete/v1")
public class DrinkRestController {

    private final DrinkService drinkService;

    public DrinkRestController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping("/categories")
    public List<CategoryDto> getAllDrinkCategories() {
        return drinkService.getAllDrinkCategories().stream()
                .map(category -> new CategoryDto(category.getName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/drinks")
    public List<DrinkDto> getAllFilteredDrinks(
            @RequestParam(value = "category", required = false) String categoryValue,
            @RequestParam(value = "name", required = false) String keyword) {
        boolean categoryFilterIsPresent = categoryValue != null && !categoryValue.isEmpty();
        boolean nameFilterIsPresent = keyword != null && !keyword.isEmpty();

        if (categoryFilterIsPresent && nameFilterIsPresent) {
            return new ArrayList<>();
        }

        if (categoryFilterIsPresent) {
            Category category = new Category(categoryValue);
            return drinkService.getAllDrinksByCategory(category).stream()
                    .map(drink -> new DrinkDto(drink.getName(), drink.getGlass(), drink.getInstructions(),
                            drink.getIngredients(), drink.getThumbnail()))
                    .collect(Collectors.toList());
        }

        if (nameFilterIsPresent) {
            Drink drinkFilter = new Drink(keyword, null, null, null, null);
            return drinkService.getAllDrinksWithSpecificKeywordName(drinkFilter).stream()
                    .map(drink -> new DrinkDto(drink.getName(), drink.getGlass(), drink.getInstructions(),
                            drink.getIngredients(), drink.getThumbnail()))
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }
}
