package com.amadeus.ikramdagci.domain.service;

import com.amadeus.ikramdagci.domain.model.dto.AirportDto;
import com.amadeus.ikramdagci.domain.model.request.CreateAirportRequest;
import com.amadeus.ikramdagci.domain.entity.Airport;
import com.amadeus.ikramdagci.domain.ex.AirportNotFoundException;
import com.amadeus.ikramdagci.domain.repository.AirportRepository;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static com.amadeus.ikramdagci.util.EntityDtoMapper.mapAirportEntity2Dto;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames={"airports"})
public class AirportService {

    private final AirportRepository airportRepository;
    private FlightService flightService;
    private AirportService self; // Self-injecting to utilize cached methods within this service

    @CacheEvict(value = "allAirportDtos", allEntries = true)
    public AirportDto create(final CreateAirportRequest request) {
        final Airport airport = airportRepository.save(Airport.builder().city(request.getCity()).code(request.getCode()).build());
        return mapAirportEntity2Dto(airport);
    }
    @CacheEvict
    public void delete(Long id){
        if(!airportRepository.existsById(id)) throw new AirportNotFoundException(id);
        flightService.deleteByDepartureOrArrivalAirportId(id);
        airportRepository.deleteById(id);
    }

    @Caching(evict = {
            @CacheEvict(key = "#id"),
            @CacheEvict(value = "allAirportDtos", allEntries = true)
    })
    public AirportDto update(final Long id, final CreateAirportRequest request) {
        final Airport airport = self.fetchAirport(id);
        airport.setCity(request.getCity());
        airport.setCode(request.getCode());
        return mapAirportEntity2Dto(airportRepository.save(airport));
    }

    @Cacheable("allAirportDtos")
    public Collection<AirportDto> findAll() {
        return mapAirportEntity2Dto(airportRepository.findAll());
    }

    public AirportDto findById(final Long id) {
        final Airport airport = self.fetchAirport(id);
        return mapAirportEntity2Dto(airport);
    }

    @Cacheable
    public Airport fetchAirport(final Long id) {
        return airportRepository.findById(id).orElseThrow(() -> new AirportNotFoundException(id));
    }

    @Cacheable
    public Airport fetchAirport(final String code){
        return airportRepository.findByCode(code).orElseThrow(() -> new AirportNotFoundException(code));
    }

    @Autowired
    public void setFlightService(@Lazy final FlightService flightService) {
        this.flightService = flightService;
    }

    @Autowired
    public void setSelf(@Lazy final AirportService self) {
        this.self = self;
    }

}
