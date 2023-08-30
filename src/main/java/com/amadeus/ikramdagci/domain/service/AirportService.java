package com.amadeus.ikramdagci.domain.service;

import com.amadeus.ikramdagci.domain.dto.AirportDto;
import com.amadeus.ikramdagci.domain.dto.CreateAirportRequest;
import com.amadeus.ikramdagci.domain.entity.Airport;
import com.amadeus.ikramdagci.domain.ex.AirportNotFoundException;
import com.amadeus.ikramdagci.domain.ex.MyResourceNotFoundException;
import com.amadeus.ikramdagci.domain.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

import static com.amadeus.ikramdagci.util.EntityDtoMapper.mapAirportEntity2Dto;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportDto create(final CreateAirportRequest request) {
        final Airport airport = airportRepository.save(Airport.builder().city(request.getCity()).code(request.getCode()).build());
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

    public Collection<AirportDto> findAll() {
        return mapAirportEntity2Dto(airportRepository.findAll());
    }

    public AirportDto findById(final Long id) {
        final Airport airport = airportRepository.findById(id).orElseThrow(() -> new AirportNotFoundException(id));
        return mapAirportEntity2Dto(airport);
    }
}
