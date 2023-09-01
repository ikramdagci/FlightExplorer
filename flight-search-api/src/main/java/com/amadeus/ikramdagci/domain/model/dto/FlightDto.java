package com.amadeus.ikramdagci.domain.model.dto;

import com.amadeus.ikramdagci.domain.model.MonetaryAmountWrapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;

@Builder
public record FlightDto(
        Long id,
        AirportDto departureAirport,
        AirportDto arrivalAirport,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime departureDateTime,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime arrivalDateTime,
        MonetaryAmountWrapper price
) {}
