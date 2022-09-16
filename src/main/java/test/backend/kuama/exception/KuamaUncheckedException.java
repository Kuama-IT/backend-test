package test.backend.kuama.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class KuamaUncheckedException extends RuntimeException {
	private final String code;
	private final String message;

	public KuamaUncheckedException(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
