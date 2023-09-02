package com.amadeus.ikramdagci.domain.model.request;


import com.amadeus.ikramdagci.validation.FlightArrivalNotBeforeDeparture;
import com.amadeus.ikramdagci.domain.model.MonetaryAmountWrapper;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@FlightArrivalNotBeforeDeparture
public class CreateFlightRequest {
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
