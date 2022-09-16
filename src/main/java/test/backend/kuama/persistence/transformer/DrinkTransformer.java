package test.backend.kuama.persistence.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import test.backend.kuama.dto.DrinkDto;
import test.backend.kuama.persistence.model.DrinkItem;

@Component
public class DrinkTransformer {
	public List<DrinkItem> getDrinkItem(List<DrinkDto> drinks) {
		return drinks
				.stream()
				.map(drinkDto -> DrinkItem
						.builder()
						.glass(drinkDto.getGlass())
						.ingredients(drinkDto.getIngredients())
						.thumbnail(drinkDto.getThumbnail())
						.name(drinkDto.getName())
						.instructions(drinkDto.getInstructions())
						.build())
				.collect(Collectors.toList());
	}
}
