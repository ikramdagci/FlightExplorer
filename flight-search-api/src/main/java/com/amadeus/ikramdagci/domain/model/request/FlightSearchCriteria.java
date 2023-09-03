package com.amadeus.ikramdagci.domain.model.request;

import com.amadeus.ikramdagci.validation.FlightArrivalNotBeforeDeparture;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;
@Data
public class FlightSearchCriteria {
    @Schema(example = "SAW")
    @NotEmpty
    private String departureAirportCode;
    @Schema(example = "JFK")
    @NotEmpty
    private String arrivalAirportCode;
    @Schema(example = "2024-10-05")
    @Future
    private LocalDate departureDate;
    @Schema(example = "2024-10-05")
    @Future
    private LocalDate returnDate;


}
