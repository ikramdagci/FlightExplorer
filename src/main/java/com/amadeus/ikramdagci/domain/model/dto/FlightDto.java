package com.amadeus.ikramdagci.domain.model.dto;

import com.amadeus.ikramdagci.domain.model.MonetaryAmountWrapper;
import lombok.Builder;


import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Builder
public record FlightDto(
        Long id,
        AirportDto departureAirport,
        AirportDto arrivalAirport,
        LocalDateTime departureDateTime,
        LocalDateTime arrivalDateTime,
        MonetaryAmountWrapper price
) {}
