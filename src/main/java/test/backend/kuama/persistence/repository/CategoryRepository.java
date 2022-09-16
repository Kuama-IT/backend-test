package test.backend.kuama.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import test.backend.kuama.persistence.model.CategoryItem;

public interface CategoryRepository extends MongoRepository<CategoryItem, String> {
}
