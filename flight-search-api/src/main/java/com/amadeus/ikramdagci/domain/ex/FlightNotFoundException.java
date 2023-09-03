package com.amadeus.ikramdagci.domain.ex;

public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(final Long id) {
        super("Flight not found with id: " + id);
    }

    public FlightNotFoundException(final String message) {
        super(message);
    }
}
