package it.kuama.backendtest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class BackendTestConfiguration {
	
	public final static String DEFAULT_REST_TEMPLATE = "defaultRestTemplate";
	
	public final static String COCKTAILDB_REST_TEMPLATE = "cocktailDBRestTemplate";

	/**
	 * Default REST class for HTTP requests 
	 * */
	@Bean(DEFAULT_REST_TEMPLATE)
	@ConditionalOnMissingBean(RestTemplate.class)
	public RestTemplate defaultRestTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * REST class for HTTP GET request to cocktailDB 
	 * */
	@Bean(COCKTAILDB_REST_TEMPLATE)
	public RestTemplate cocktailDBRestTemplate_get() {
		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory("https://www.thecocktaildb.com/api/json/v1/1/");

		RestTemplate cocktailDbRestTemplate = new RestTemplate();
		cocktailDbRestTemplate.setUriTemplateHandler(uriBuilderFactory);
		return cocktailDbRestTemplate;
	}
	
}
