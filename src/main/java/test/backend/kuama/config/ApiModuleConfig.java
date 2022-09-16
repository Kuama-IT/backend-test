package test.backend.kuama.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import test.backend.kuama.config.advice.ControllerAdvice;

@Configuration
public class ApiModuleConfig {

	@Bean
	public ControllerAdvice controllerAdvice() {
		return new ControllerAdvice();
	}
}
