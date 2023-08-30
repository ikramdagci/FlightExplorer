package com.amadeus.ikramdagci.domain.service;

import com.amadeus.ikramdagci.domain.dto.CreateAirportRequest;
import com.amadeus.ikramdagci.domain.entity.Airport;
import com.amadeus.ikramdagci.domain.repository.AirportRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public Airport create(final CreateAirportRequest request) {
        return airportRepository.save(Airport.builder().city(request.getCity()).build());
    }
}
