package com.amadeus.ikramdagci.domain.service;

import com.amadeus.ikramdagci.domain.dto.CreateAirportRequest;
import com.amadeus.ikramdagci.domain.entity.Airport;
import com.amadeus.ikramdagci.domain.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public Airport create(final CreateAirportRequest request) {
        return airportRepository.save(Airport.builder().city(request.getCity()).build());
    }

    public void delete(Long id){
        airportRepository.deleteById(id);
    }
}
