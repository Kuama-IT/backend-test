package it.akaisara.backendtest.infrastructure.externalApi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DrinksDto {

    @JsonProperty("drinks")
    private List<DrinkDto> drinkDtoList = new ArrayList<>();

    @JsonProperty("drinks")
    public List<DrinkDto> getDrinks() {
        return drinkDtoList;
    }

    @JsonProperty("drinks")
    public void setDrinks(List<DrinkDto> drinkDtos) {
        this.drinkDtoList = drinkDtos;
    }
}
