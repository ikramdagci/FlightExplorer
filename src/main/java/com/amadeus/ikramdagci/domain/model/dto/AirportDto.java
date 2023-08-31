package com.amadeus.ikramdagci.domain.model.dto;

import lombok.Builder;

@Builder
public record AirportDto(Long id,String city,String code) {
}
