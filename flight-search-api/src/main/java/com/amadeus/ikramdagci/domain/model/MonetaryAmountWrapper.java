package com.amadeus.ikramdagci.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;

/**
 * A wrapper class used to represent a MonetaryAmount in a simplified form for requests
 * without directly exposing the MonetaryAmount object.
 *
 * @author Ikram Dagci
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MonetaryAmountWrapper {

    @JsonProperty("amount")
    @Schema(example = "99.96")
    @DecimalMin(value = "0", inclusive = false)
    private BigDecimal amount;

    @JsonProperty("currency")
    @Schema(example = "USD")
    @NotEmpty
    private String currency;

    /**
     * Creates a MonetaryAmountWrapper instance from a MonetaryAmount object.
     *
     * @param monetaryAmount The MonetaryAmount to be wrapped.
     * @return A new MonetaryAmountWrapper instance representing the provided MonetaryAmount.
     */
    public static MonetaryAmountWrapper from(MonetaryAmount monetaryAmount) {
        return new MonetaryAmountWrapper(
                monetaryAmount.getNumber().numberValue(BigDecimal.class),
                monetaryAmount.getCurrency().getCurrencyCode()
        );
    }

    public MonetaryAmount monetaryAmount(){
        return Money.parse(toString());
    }

    /**
     * Provides a String representation of the MonetaryAmountWrapper.
     *
     * @return String representation of the form "currency amount".
     */
    @Override
    public String toString() {
        return currency + " " + amount.toString();
    }
}




