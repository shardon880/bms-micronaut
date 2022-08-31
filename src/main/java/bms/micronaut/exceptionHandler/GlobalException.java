package bms.micronaut.exceptionHandler;

public class GlobalException extends RuntimeException{
    public GlobalException(Throwable throwable){super(throwable);}
}
