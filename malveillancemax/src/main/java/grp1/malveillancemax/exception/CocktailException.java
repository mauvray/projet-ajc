package grp1.malveillancemax.exception;

public class CocktailException extends RuntimeException{

    public CocktailException(){
        super();
    }
    
    public CocktailException(String message){
        super(message);
    }
}
