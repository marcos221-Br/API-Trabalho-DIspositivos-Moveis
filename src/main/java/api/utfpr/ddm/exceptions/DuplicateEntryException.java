package api.utfpr.ddm.exceptions;

public class DuplicateEntryException extends RuntimeException{
    
    public DuplicateEntryException(String message){
        super(message);
    }
}
