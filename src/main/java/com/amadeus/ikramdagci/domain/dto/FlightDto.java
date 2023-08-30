package com.amadeus.ikramdagci.domain.dto;

import lombok.Builder;


import javax.money.MonetaryAmount;
import java.time.LocalDateTime;

@Builder
public record FlightDto(
        Long id,
        AirportDto departureAirport,
        AirportDto arrivalAirport,
        LocalDateTime departureDateTime,
        LocalDateTime arrivalDateTime,
        MonetaryWrapper price
) {}
