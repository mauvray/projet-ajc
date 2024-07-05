package grp1.BarBis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class AnimationException extends RuntimeException {

    public AnimationException(){

    }

    public AnimationException(String message){
        super(message);
    }
}
