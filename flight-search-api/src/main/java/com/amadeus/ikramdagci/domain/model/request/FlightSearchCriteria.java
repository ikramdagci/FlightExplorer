package com.amadeus.ikramdagci.domain.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;
@Data
public class FlightSearchCriteria {
    @NotEmpty
    @Schema(example = "SAW")
    private String departureAirportCode;
    @NotEmpty
    @Schema(example = "JFK")
    private String arrivalAirportCode;
    @Future
    @Schema(example = "2024-10-05")
    private LocalDate departureDate;
    @Future
    @Schema(example = "2024-10-07",
            description = "Optional: If specified, return flights will be included in the search results.",
            nullable = true)
    private LocalDate returnDate;

}
