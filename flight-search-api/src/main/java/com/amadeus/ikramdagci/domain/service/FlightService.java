package com.amadeus.ikramdagci.domain.service;

import com.amadeus.ikramdagci.domain.entity.Airport;
import com.amadeus.ikramdagci.domain.entity.Flight;
import com.amadeus.ikramdagci.domain.ex.FlightNotFoundException;
import com.amadeus.ikramdagci.domain.model.CreateFlightPayload;
import com.amadeus.ikramdagci.domain.model.dto.FlightDto;
import com.amadeus.ikramdagci.domain.model.request.CreateFlightRequest;
import com.amadeus.ikramdagci.domain.repository.FlightRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.Money;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static com.amadeus.ikramdagci.util.EntityDtoMapper.mapFlightEntity2Dto;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames={"flights"})
public class FlightService {

    private final FlightRepository flightRepository;
    private final AirportService airportService;

    public FlightDto create(final CreateFlightPayload request) {
        final Airport departureAirport = airportService.fetchAirport(request.getDepartureAirportCode());
        final Airport arrivalAirport = airportService.fetchAirport(request.getArrivalAirportCode());
        final Flight flight = buildFlightEntity(request, departureAirport, arrivalAirport);
        return mapFlightEntity2Dto(flightRepository.save(flight));
    }

    public Collection<FlightDto> create(final List<? extends CreateFlightPayload> flightPayloads){
        final List<Flight> flights = buildFlightEntity(flightPayloads);
        return mapFlightEntity2Dto(flightRepository.saveAll(flights));
    }
    public Collection<FlightDto> findAll() {
        return mapFlightEntity2Dto(flightRepository.findAll());
    }

    public FlightDto findById(final Long id) {
        final Flight flight = fetchFlight(id);
        return mapFlightEntity2Dto(flight);
    }

    public void delete(final Long id) {
        final boolean exists = flightRepository.existsById(id);
        if (!exists) throw new FlightNotFoundException(id);
        flightRepository.deleteById(id);
    }


    public void deleteByDepartureOrArrivalAirportId(Long airportId){
        flightRepository.deleteByDepartureOrArrivalAirportId(airportId);
    }

    public FlightDto update(final Long id, final CreateFlightRequest request) {
        final Flight flight = fetchFlight(id);
        flight.setDepartureAirport(airportService.fetchAirport(request.getDepartureAirportCode()));
        flight.setDepartureDateTime(request.getDepartureDateTime());
        flight.setArrivalAirport(airportService.fetchAirport(request.getArrivalAirportCode()));
        flight.setArrivalDateTime(request.getArrivalDateTime());
        flight.setPrice(request.getPrice().monetaryAmount());
        return mapFlightEntity2Dto(flightRepository.save(flight));
    }

    private Flight fetchFlight(final Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException(id));
    }


    private Flight buildFlightEntity(@NotNull final CreateFlightPayload request, final Airport departureAirport, final Airport arrivalAirport) {
        return Flight.builder()
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .departureDateTime(request.getDepartureDateTime())
                .arrivalDateTime(request.getArrivalDateTime())
                .price(Money.parse(request.getPrice().toString()))
                .build();
    }

    private List<Flight> buildFlightEntity(List<? extends CreateFlightPayload> flightPayloads) {
        return flightPayloads.stream()
                .map(payload -> {
                    final Airport departureAirport = airportService.fetchAirport(payload.getDepartureAirportCode());
                    final Airport arrivalAirport = airportService.fetchAirport(payload.getArrivalAirportCode());
                    return buildFlightEntity(payload, departureAirport, arrivalAirport);
                })
                .toList();
    }

}
