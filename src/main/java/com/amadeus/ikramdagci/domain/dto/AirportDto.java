package com.amadeus.ikramdagci.domain.dto;

import lombok.Builder;

@Builder
public record AirportDto(Long id,String city,String code) {
}
