package it.akaisara.backendtest.infrastructure.externalApi;

import it.akaisara.backendtest.domain.model.Category;
import it.akaisara.backendtest.domain.model.Drink;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DrinkExternalApiServiceTest {

    @Autowired
    private DrinkExternalApiService drinkExternalApiService;

    @Test
    void givenValidExternalApi_whenGetCategories_thenRetrieveValidListOfCategories() {
        // Act
        List<Category> result = drinkExternalApiService.getAllDrinkCategories();

        // Assert
        assertThat(result).isNotNull().isNotEmpty();
    }

    @Test
    void givenValidExtApiAndValidCategory_whenGetDrinksWithSpecificCategory_thenGetListOfValidDrinks() {
        // Assert
        String categoryName = "shot";
        Category category = new Category(categoryName);

        // Act
        List<Drink> result = drinkExternalApiService.getAllDrinksByCategory(category);

        // Assert
        assertThat(result).isNotNull().isNotEmpty();
        // controllo che ogni drink abbia la categoria che ho segnato
    }

    @Test
    void givenValidExtApiAndInvalidCategory_whenGetDrinksWithSpecificCategory_thenGetAnEmptyList() {
        // Assert
        String categoryName = "categoryThatNotExists";
        Category category = new Category(categoryName);

        // Act
        List<Drink> result = drinkExternalApiService.getAllDrinksByCategory(category);

        // Assert
        assertThat(result).isNotNull().isEmpty();
    }

    @Test
    void givenValidExtApiAndValidKeyword_whenGetDrinksWithSpecificName_thenGetListOfValidDrinksWithSameNameAsKeywordIgnoringCase() {
        // Assert
        String drinkName = "spritz";
        Drink drinkWithSpecificName = new Drink(drinkName, null, null, null, null);

        // Act
        List<Drink> result = drinkExternalApiService.getAllDrinksWithSpecificKeywordName(drinkWithSpecificName);

        // Assert
        assertThat(result).isNotNull().isNotEmpty().map(Drink::getName)
                .allMatch(name -> name.toLowerCase().contains(drinkName.toLowerCase()));
    }

    @Test
    void givenValidExtApiAndInvalidKeyword_whenGetDrinksWithSpecificName_thenGetAnEmptyList() {
        // Assert
        String drinkName = "drinkThatNotExists";
        Drink drinkWithSpecificName = new Drink(drinkName, null, null, null, null);

        // Act
        List<Drink> result = drinkExternalApiService.getAllDrinksWithSpecificKeywordName(drinkWithSpecificName);

        // Assert
        assertThat(result).isNotNull().isEmpty();
    }
}