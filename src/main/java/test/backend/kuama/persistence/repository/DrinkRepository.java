package test.backend.kuama.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import test.backend.kuama.persistence.model.DrinkItem;

public interface DrinkRepository extends MongoRepository<DrinkItem, String> {
}
