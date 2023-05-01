package it.akaisara.backendtest.application;

import java.util.List;

public record DrinkDto(String name, String glass, String instructions, List<String> ingredients, String thumbnail) {
}
