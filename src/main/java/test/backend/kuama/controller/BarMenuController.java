package test.backend.kuama.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import test.backend.kuama.api.BarMenuApi;
import test.backend.kuama.dto.CategoryResponseDto;
import test.backend.kuama.dto.DrinksResponseDto;
import test.backend.kuama.service.CategoryService;
import test.backend.kuama.service.DrinkService;

@RestController
@AllArgsConstructor
public class BarMenuController implements BarMenuApi {

	private final DrinkService drinkService;
	private final CategoryService categoryService;

	@Override
	public ResponseEntity<DrinksResponseDto> _getAllDrinksByCategory(String category, String language) {
		return ResponseEntity.ok(drinkService.getAllDrinksByCategory(category, language));
	}

	@Override
	public ResponseEntity<DrinksResponseDto> _getAllDrinksByName(String name, String language) {
		return ResponseEntity.ok(drinkService.getAllDrinksByName(name, language));
	}

	@Override
	public ResponseEntity<CategoryResponseDto> _getAllDrinksCategories() {
		return ResponseEntity.ok(categoryService.getAllDrinksCategories());
	}
}
