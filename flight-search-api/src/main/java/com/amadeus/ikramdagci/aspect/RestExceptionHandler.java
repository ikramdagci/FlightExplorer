package com.amadeus.ikramdagci.aspect;

import com.amadeus.ikramdagci.domain.ex.AirportNotFoundException;
import com.amadeus.ikramdagci.domain.ex.FlightNotFoundException;
import com.amadeus.ikramdagci.domain.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.money.format.MonetaryParseException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {AirportNotFoundException.class,FlightNotFoundException.class, MonetaryParseException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorResponse<?> handleEntityNotFoundException(RuntimeException exception) {
        log.error(exception.getMessage());
        return new ErrorResponse<>(exception.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatusCode status, final WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if(error instanceof final FieldError fieldError){
                validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
            } else {
                validationErrors.put(error.getObjectName(), error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(new ErrorResponse<>(validationErrors),HttpStatus.BAD_REQUEST);    }
}