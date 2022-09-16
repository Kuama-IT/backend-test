package test.backend.kuama.service.transformer;

import java.util.stream.Collectors;

import test.backend.kuama.dto.CategoryResponseDto;
import test.backend.kuama.external.model.Drink;
import test.backend.kuama.external.model.Drinks;

public final class CategoriesTransformer {

	public static CategoryResponseDto getCategoryResponseDtoFromDrinks(Drinks drinks) {
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		categoryResponseDto
				.setCategories(drinks.getDrinks().stream().map(Drink::getStrCategory).collect(Collectors.toList()));
		return categoryResponseDto;
	}
}
