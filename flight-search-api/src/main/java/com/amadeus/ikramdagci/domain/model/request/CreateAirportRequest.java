package com.amadeus.ikramdagci.domain.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateAirportRequest {
    @Schema(example = "Istanbul")
    private String city;
    @Schema(example = "SAW")
    private String code;

}
