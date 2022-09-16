package test.backend.kuama.config.advice;

import java.util.Objects;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import test.backend.kuama.dto.ErrorApiResponseDto;
import test.backend.kuama.exception.KuamaUncheckedException;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> problem(final Throwable e) {

		ErrorApiResponseDto error = new ErrorApiResponseDto();
		error.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		error.setMessage(e.getMessage());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

	@ExceptionHandler(KuamaUncheckedException.class)
	public ResponseEntity<?> handleConstraintViolatedException(KuamaUncheckedException e, WebRequest request) {

		ErrorApiResponseDto error = new ErrorApiResponseDto();
		error.setCode(e.getCode());
		error.setMessage(e.getMessage());

		return handleExceptionInternal(e, error, new HttpHeaders(),
				Objects.requireNonNull(HttpStatus.resolve(Integer.parseInt(error.getCode()))), request);
	}
}
