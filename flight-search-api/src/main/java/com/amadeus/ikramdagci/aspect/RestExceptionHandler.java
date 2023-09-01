package com.amadeus.ikramdagci.aspect;

import com.amadeus.ikramdagci.domain.ex.AirportNotFoundException;
import com.amadeus.ikramdagci.domain.ex.FlightNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {AirportNotFoundException.class,FlightNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected String handleAirportNotFoundException(RuntimeException exception) {
        log.error(exception.getMessage());
        return exception.getMessage();
    }


}