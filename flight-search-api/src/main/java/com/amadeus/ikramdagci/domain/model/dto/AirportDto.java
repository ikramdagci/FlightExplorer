package com.amadeus.ikramdagci.domain.model.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record AirportDto(Long id,String city,String code) implements Serializable {
}
