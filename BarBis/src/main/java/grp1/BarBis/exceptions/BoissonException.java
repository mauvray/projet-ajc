package grp1.BarBis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class BoissonException extends RuntimeException {
    public BoissonException(){

    }

    public BoissonException(String message){
        super(message);
    }

}
