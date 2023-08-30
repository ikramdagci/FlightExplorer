package com.amadeus.ikramdagci.domain.ex;

public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException(final Long id) {
        super("Airport with id:" + id + " not found");
    }
}
