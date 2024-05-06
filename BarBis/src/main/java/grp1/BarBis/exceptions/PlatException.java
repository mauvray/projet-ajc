package grp1.BarBis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class PlatException extends RuntimeException {
	public PlatException() {

	}

	public PlatException(String message) {
		super(message);
	}
}
