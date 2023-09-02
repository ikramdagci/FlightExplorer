package com.amadeus.ikramdagci.validation;


import com.amadeus.ikramdagci.domain.model.request.CreateFlightRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

public class FlightArrivalNotBeforeDepartureValidator implements ConstraintValidator<FlightArrivalNotBeforeDeparture, CreateFlightRequest> {

    @Override
    public boolean isValid(CreateFlightRequest request, ConstraintValidatorContext context) {
        if(Stream.of(request,request.getDepartureDateTime(),request.getArrivalDateTime()).anyMatch(Objects::isNull)){
            return false;
        }
        final LocalDateTime departureDateTime = request.getDepartureDateTime();
        final LocalDateTime arrivalDateTime = request.getArrivalDateTime();

        return arrivalDateTime.isAfter(departureDateTime);
    }
}
