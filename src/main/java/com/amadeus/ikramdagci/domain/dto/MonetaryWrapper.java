package com.amadeus.ikramdagci.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class MonetaryWrapper {
    @JsonProperty("amount")
    @Schema(
            example = "99.96"
    )
    private BigDecimal amount;
    @JsonProperty("currency")
    @Schema(
            example = "USD"
    )
    private String currency;

    @Override
    public String toString() {
        return currency + " " + amount.toString();
    }

}
