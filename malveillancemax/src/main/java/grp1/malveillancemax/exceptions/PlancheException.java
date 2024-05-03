package grp1.malveillancemax.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class PlancheException extends RuntimeException {
	public PlancheException() {

	}

	public PlancheException(String message) {
		super(message);
	}
}

