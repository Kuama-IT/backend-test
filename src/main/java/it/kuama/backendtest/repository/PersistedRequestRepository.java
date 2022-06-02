package it.kuama.backendtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.kuama.backendtest.cocktaildb.entity.PersistedRequest;
/**
 * 
 *	Standard Spring data JPA Repository for {@link PersistedRequest}
 *@author Pietro
 */
public interface PersistedRequestRepository extends JpaRepository<PersistedRequest, Long> {

}
