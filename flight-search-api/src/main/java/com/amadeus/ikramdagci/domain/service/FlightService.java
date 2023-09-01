package com.amadeus.ikramdagci.domain.service;

import com.amadeus.ikramdagci.domain.ex.FlightNotFoundException;
import com.amadeus.ikramdagci.domain.model.request.CreateFlightRequest;
import com.amadeus.ikramdagci.domain.model.dto.FlightDto;
import com.amadeus.ikramdagci.domain.entity.Airport;
import com.amadeus.ikramdagci.domain.entity.Flight;
import com.amadeus.ikramdagci.domain.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static com.amadeus.ikramdagci.util.EntityDtoMapper.mapFlightEntity2Dto;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final AirportService airportService;
    public FlightDto create(final CreateFlightRequest request) {
        final Airport departureAirport = airportService.fetchAirport(request.getDepartureAirportCode());
        final Airport arrivalAirport = airportService.fetchAirport(request.getArrivalAirportCode());
        final Flight flight = Flight.builder()
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .departureDateTime(request.getDepartureDateTime())
                .arrivalDateTime(request.getArrivalDateTime())
                .price(Money.parse(request.getPrice().toString()))
                .build();
        return mapFlightEntity2Dto(flightRepository.save(flight));
    }

    public Collection<FlightDto> findAll() {
        return mapFlightEntity2Dto(flightRepository.findAll());
    }


    public FlightDto findById(final Long id) {
        final Flight flight = flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException(id));
        return mapFlightEntity2Dto(flight);
    }
}
