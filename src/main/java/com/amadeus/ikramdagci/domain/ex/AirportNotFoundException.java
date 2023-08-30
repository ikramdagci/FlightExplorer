package com.amadeus.ikramdagci.domain.ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException(final Long id) {
        super("Airport with id:" + id + " not found");
    }
}
