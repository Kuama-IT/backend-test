package it.kuama.backendtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.kuama.backendtest.cocktaildb.entity.PersistedRequest;
import it.kuama.backendtest.repository.PersistedRequestRepository;

/**
 * Service for request persistance
 * @author Pietro
 *
 */

@Service
public class RequestPersistanceService {
	
	@Autowired
	private PersistedRequestRepository persistedRequestRepository;
	
	private static final ObjectMapper jsonMapper = new ObjectMapper();
	
	public void persistRequest(String request_name, Object response) {
		PersistedRequest newRequest;
		try {
			newRequest = new PersistedRequest(request_name, jsonMapper.writeValueAsString(response));
			persistedRequestRepository.save(newRequest);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
