package api.utfpr.ddm.exceptions;

public class NotFoundException extends RuntimeException{
    
    public NotFoundException(String message){
        super(message);
    }
}
