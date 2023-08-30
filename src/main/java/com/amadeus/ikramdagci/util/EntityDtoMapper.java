package com.amadeus.ikramdagci.util;

import com.amadeus.ikramdagci.domain.dto.AirportDto;
import com.amadeus.ikramdagci.domain.entity.Airport;
import com.amadeus.ikramdagci.domain.entity.BaseEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
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

}
