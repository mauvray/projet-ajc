package grp1.malveillancemax.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class TapasException extends RuntimeException {
	public TapasException() {

	}

	public TapasException(String message) {
		super(message);
	}
}