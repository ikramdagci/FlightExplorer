package com.amadeus.ikramdagci.util;

import com.amadeus.ikramdagci.domain.dto.AirportDto;
import com.amadeus.ikramdagci.domain.dto.FlightDto;
import com.amadeus.ikramdagci.domain.dto.MonetaryWrapper;
import com.amadeus.ikramdagci.domain.entity.Airport;
import com.amadeus.ikramdagci.domain.entity.BaseEntity;
import com.amadeus.ikramdagci.domain.entity.Flight;
import org.springdoc.core.converters.models.MonetaryAmount;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class EntityDtoMapper {
    private EntityDtoMapper(){}

    public static <T> T mapEntity2Dto(BaseEntity baseEntity){
        return null;
    }

    public static AirportDto mapAirportEntity2Dto(Airport airport) {
        return Optional.ofNullable(airport)
                .map(it -> AirportDto.builder().id(it.getId()).code(it.getCode()).city(it.getCity()).build())
                .orElse(null);
    }

    public static Collection<AirportDto>  mapAirportEntity2Dto(Collection<Airport> airports) {
        return Optional.ofNullable(airports)
                .map(all -> all.stream().map(EntityDtoMapper::mapAirportEntity2Dto).toList())
                .orElse(Collections.emptyList());
    }


    public static FlightDto mapFlightEntity2Dto(Flight flight) {
        return Optional.ofNullable(flight)
                .map(it -> FlightDto.builder()
                        .id(it.getId())
                        .departureAirport(mapAirportEntity2Dto(it.getDepartureAirport()))
                        .arrivalAirport(mapAirportEntity2Dto(it.getArrivalAirport()))
                        .departureDateTime(it.getDepartureDateTime())
                        .arrivalDateTime(it.getArrivalDateTime())
                        .price(new MonetaryWrapper(it.getPrice().getNumber().numberValue(BigDecimal.class),it.getPrice().getCurrency().getCurrencyCode()))
                        .build())
                .orElse(null);
    }

}
