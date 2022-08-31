package bms.micronaut.exceptionHandler;

public class UserExistException extends RuntimeException{
    public UserExistException(String str) {
        super(str);
    }
}
