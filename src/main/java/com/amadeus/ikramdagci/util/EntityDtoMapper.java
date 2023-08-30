package com.amadeus.ikramdagci.util;

import com.amadeus.ikramdagci.domain.dto.AirportDto;
import com.amadeus.ikramdagci.domain.entity.Airport;
import com.amadeus.ikramdagci.domain.entity.BaseEntity;

import java.util.Optional;

public final class EntityDtoMapper {
    private EntityDtoMapper(){}

    public static <T> T mapEntity2Dto(BaseEntity baseEntity){
        return null;
    }

    public static AirportDto mapAirportEntity2Dto(Airport airport) {
        return Optional.ofNullable(airport)
                .map(it -> AirportDto.builder().id(it.getId()).city(it.getCode()).city(it.getCity()).build())
                .orElse(null);
    }

}
