package test.backend.kuama.persistence.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import test.backend.kuama.persistence.model.CategoryItem;

@Component
public class CategoryTransformer {
	public List<CategoryItem> getCategoryItem(List<String> categories) {
		return categories.stream().map(name -> CategoryItem.builder().name(name).build()).collect(Collectors.toList());
	}
}
