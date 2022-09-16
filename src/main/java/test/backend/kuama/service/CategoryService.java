package test.backend.kuama.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import test.backend.kuama.dto.CategoryResponseDto;
import test.backend.kuama.external.CocktailRest;
import test.backend.kuama.persistence.repository.CategoryRepository;
import test.backend.kuama.persistence.transformer.CategoryTransformer;
import test.backend.kuama.service.transformer.CategoriesTransformer;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {
	private final CocktailRest cocktailRest;
	private final CategoryRepository categoryRepository;
	private final CategoryTransformer categoryTransformer;

	public CategoryResponseDto getAllDrinksCategories() {
		CategoryResponseDto categoryResponseDto = CategoriesTransformer
				.getCategoryResponseDtoFromDrinks(cocktailRest.getAllDrinksCategories());
		categoryRepository.saveAll(categoryTransformer.getCategoryItem(categoryResponseDto.getCategories()));

		return categoryResponseDto;
	}
}
