package it.akaisara.backendtest.infrastructure.externalApi;

import it.akaisara.backendtest.domain.model.Category;
import it.akaisara.backendtest.domain.model.Drink;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinkExternalApiService {

    private final String categoriesEndpoint;

    private final String drinksByCategoryEndpoint;

    private final String drinksByNameEndpoint;

    private final String drinkByIdEndpoint;

    private final WebClient client;

    public DrinkExternalApiService(@Value("${externalApi.baseUrl}") String baseUrl,
                                   @Value("${externalApi.categoriesEndpoint}") String categoriesEndpoint,
                                   @Value("${externalApi.drinksByCategoryEndpoint}")String drinksByCategoryEndpoint,
                                   @Value("${externalApi.drinksByNameEndpoint}")String drinksByNameEndpoint,
                                   @Value("${externalApi.drinkByIdEndpoint}") String drinkByIdEndpoint) {
        this.categoriesEndpoint = categoriesEndpoint;
        this.drinksByCategoryEndpoint = drinksByCategoryEndpoint;
        this.drinksByNameEndpoint = drinksByNameEndpoint;
        this.drinkByIdEndpoint = drinkByIdEndpoint;
        this.client = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public List<Category> getAllDrinkCategories() {
        Mono<DrinksDto> drinkCategories = client.get()
                .uri(categoriesEndpoint)
                .retrieve()
                .bodyToMono(DrinksDto.class);

        if (drinkCategories.block() != null) {
            return drinkCategories.block().getDrinks().stream().map(DrinkDto::convertToCategory).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public List<Drink> getAllDrinksByCategory(Category category) {
        Mono<DrinksDto> drinkCategories = client.get()
                .uri(drinksByCategoryEndpoint + category.getName())
                .retrieve()
                .bodyToMono(DrinksDto.class)
                .onErrorReturn(new DrinksDto());

        if (drinkCategories.block() != null && drinkCategories.block().getDrinks() != null) {
            return drinkCategories.block().getDrinks().stream().map(drink -> getInfoAboutDrinkByDrinkId(drink.getIdDrink())).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public List<Drink> getAllDrinksWithSpecificKeywordName(Drink drinkWithSpecificName) {
        Mono<DrinksDto> drinkCategories = client.get()
                .uri(drinksByNameEndpoint + drinkWithSpecificName.getName())
                .retrieve()
                .bodyToMono(DrinksDto.class);

        DrinksDto drinksDto = drinkCategories.block();
        if (drinksDto != null && drinksDto.getDrinks() != null) {
            return drinksDto.getDrinks().stream().map(DrinkDto::convertToDrink).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    private Drink getInfoAboutDrinkByDrinkId(String drinkId) {
        Mono<DrinksDto> drink = client.get()
                .uri(drinkByIdEndpoint + drinkId)
                .retrieve()
                .bodyToMono(DrinksDto.class);

        DrinksDto drinksDto = drink.block();
        if (drinksDto != null && drinksDto.getDrinks() != null && !drinksDto.getDrinks().isEmpty()) {
            return drinksDto.getDrinks().get(0).convertToDrink();
        }

        return null;
    }
}
