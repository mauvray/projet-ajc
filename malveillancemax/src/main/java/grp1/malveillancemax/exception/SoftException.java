package grp1.malveillancemax.exception;

public class SoftException extends RuntimeException {

    public SoftException(){
        super();
    }
    
    public SoftException(String message){
        super(message);
    }
}
