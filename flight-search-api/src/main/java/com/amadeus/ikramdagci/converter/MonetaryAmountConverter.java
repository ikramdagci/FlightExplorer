package com.amadeus.ikramdagci.converter;

import jakarta.persistence.AttributeConverter;
import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;

/**
 * Converts MonetaryAmount objects to and from their String representation for database storage.
 *
 * @author Ikram Dagci
 */
public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, String> {

    /**
     * Converts a MonetaryAmount to its String representation.
     *
     * @param monetaryAmount MonetaryAmount to convert.
     * @return String representation of the MonetaryAmount.
     */
    @Override
    public String convertToDatabaseColumn(final MonetaryAmount monetaryAmount) {
        return monetaryAmount.toString();
    }

    /**
     * Converts a String representation back to a MonetaryAmount.
     *
     * @param s - representation of the MonetaryAmount not null.
     * @return MonetaryAmount converted from the String.
     */
    @Override
    public MonetaryAmount convertToEntityAttribute(final String s) {
        return Money.parse(s);
    }
}
