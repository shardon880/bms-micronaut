package bms.micronaut.exceptionHandler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Produces
@Singleton
@Requires(classes = {GlobalException.class, ExceptionHandler.class})
@Slf4j
public class GlobalExceptionHandler implements ExceptionHandler<GlobalException, HttpResponse> {

    public HttpResponse handle(HttpRequest request, GlobalException exception) {
//        log.error("error occ");
//        log.error(exception.getLocalizedMessage());
//        log.error(exception.getCause().getMessage());
        Arrays.stream(exception.getStackTrace()).forEach(item ->  log.error(item.toString()));
        return HttpResponse.serverError("err");
    }
}

