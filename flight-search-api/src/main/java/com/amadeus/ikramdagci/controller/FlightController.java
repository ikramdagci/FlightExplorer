package com.amadeus.ikramdagci.controller;

import com.amadeus.ikramdagci.domain.model.request.CreateFlightRequest;
import com.amadeus.ikramdagci.domain.model.dto.FlightDto;
import com.amadeus.ikramdagci.domain.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flight")
public class FlightController {

    private final FlightService flightService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public FlightDto add(@RequestBody CreateFlightRequest request){
        return flightService.create(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<FlightDto> findAll(){
        return flightService.findAll();
    }
}
