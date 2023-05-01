package it.akaisara.backendtest.infrastructure.database;

import it.akaisara.backendtest.domain.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDatabaseRepository extends CrudRepository<Category, Integer> {
}
