package test.backend.kuama.exception;

import org.springframework.http.HttpStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionFactory {

	public KuamaUncheckedException notFound(String msg) {
		log.error(msg);
		return new KuamaUncheckedException(String.valueOf(HttpStatus.NOT_FOUND.value()), msg);
	}
}
