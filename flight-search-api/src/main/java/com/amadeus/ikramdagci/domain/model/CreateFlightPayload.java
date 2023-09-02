package com.amadeus.ikramdagci.domain.model;

import com.amadeus.ikramdagci.validation.FlightArrivalNotBeforeDeparture;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@FlightArrivalNotBeforeDeparture
@ToString
public class CreateFlightPayload {
    @Schema(example = "SAW")
    @NotEmpty
    private String departureAirportCode;
    @Schema(example = "JFK")
    @NotEmpty
    private String arrivalAirportCode;
    @Schema(example = "2024-10-05T15:30")
    @Future
    private LocalDateTime departureDateTime;
    @Schema(example = "2024-10-05T17:30")
    @Future
    private LocalDateTime arrivalDateTime;
    @Valid
    private MonetaryAmountWrapper price;

}
