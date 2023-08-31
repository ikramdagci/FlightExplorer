package com.amadeus.ikramdagci.domain.model.request;


import com.amadeus.ikramdagci.domain.model.MonetaryAmountWrapper;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CreateFlightRequest {
    @Schema(example = "SAW")
    private String departureAirportCode;
    @Schema(example = "JFK")
    private String arrivalAirportCode;
    @Schema(example = "2023-08-30T16:44")
    private LocalDateTime departureDateTime;
    @Schema(example = "2023-08-31T02:15")
    private LocalDateTime arrivalDateTime;
    private MonetaryAmountWrapper price;

}
