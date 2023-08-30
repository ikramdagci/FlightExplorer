package com.amadeus.ikramdagci.domain.service;

import com.amadeus.ikramdagci.domain.dto.AirportDto;
import com.amadeus.ikramdagci.domain.dto.CreateAirportRequest;
import com.amadeus.ikramdagci.domain.entity.Airport;
import com.amadeus.ikramdagci.domain.ex.AirportNotFoundException;
import com.amadeus.ikramdagci.domain.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.amadeus.ikramdagci.util.EntityDtoMapper.mapAirportEntity2Dto;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportDto create(final CreateAirportRequest request) {
        final Airport airport = airportRepository.save(Airport.builder().city(request.getCity()).build());
        return mapAirportEntity2Dto(airport);
    }
    public void delete(Long id){
        airportRepository.deleteById(id);
    }

    public AirportDto update(final Long id, final CreateAirportRequest request) {
        final Airport airport = airportRepository.findById(id).orElseThrow(() -> new AirportNotFoundException(id));
        airport.setCity(request.getCity());
        airport.setCode(request.getCode());
        return mapAirportEntity2Dto(airportRepository.save(airport));
    }
}
