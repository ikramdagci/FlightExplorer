package com.amadeus.ikramdagci.controller;

import com.amadeus.ikramdagci.domain.model.request.CreateFlightRequest;
import com.amadeus.ikramdagci.domain.model.dto.FlightDto;
import com.amadeus.ikramdagci.domain.service.FlightService;
import jakarta.validation.Valid;
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
    public FlightDto add(@RequestBody @Valid CreateFlightRequest request){
        return flightService.create(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<FlightDto> findAll(){
        return flightService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FlightDto findById(@PathVariable Long id){
        return flightService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        flightService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public FlightDto update(@PathVariable Long id,@Valid @RequestBody CreateFlightRequest request){
        return flightService.update(id,request);
    }

}
