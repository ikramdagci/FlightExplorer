package com.amadeus.ikramdagci.converter;

import jakarta.persistence.AttributeConverter;
import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;

public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount,String> {
    @Override
    public String convertToDatabaseColumn(final MonetaryAmount monetaryAmount) {
        return monetaryAmount.toString();
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(final String s) {
        return Money.parse(s);
    }
}
