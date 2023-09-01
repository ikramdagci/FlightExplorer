package com.amadeus.ikramdagci.domain.model.request;


import com.amadeus.ikramdagci.domain.model.MonetaryAmountWrapper;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateFlightRequest {
    @Schema(example = "SAW")
    @NotEmpty
    private String departureAirportCode;
    @Schema(example = "JFK")
    @NotEmpty
    private String arrivalAirportCode;
    @Schema(example = "2023-09-01T15:30")
    @Future
    private LocalDateTime departureDateTime;
    @Schema(example = "2023-09-01T17:30")
    @Future
    private LocalDateTime arrivalDateTime;
    private MonetaryAmountWrapper price;

}
