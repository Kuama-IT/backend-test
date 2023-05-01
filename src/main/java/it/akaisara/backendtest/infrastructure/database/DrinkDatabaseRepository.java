package it.akaisara.backendtest.infrastructure.database;

import it.akaisara.backendtest.domain.model.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkDatabaseRepository extends CrudRepository<Drink, Integer> {
}
