package com.amadeus.ikramdagci.domain.ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException(final Long id) {
        super("Airport not found with id: " + id);
    }

    public AirportNotFoundException(final String code) {
        super("Airport not found with code: " + code);
    }
}
