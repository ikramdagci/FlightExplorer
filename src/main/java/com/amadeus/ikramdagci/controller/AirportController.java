package com.amadeus.ikramdagci.controller;

import com.amadeus.ikramdagci.domain.dto.AirportDto;
import com.amadeus.ikramdagci.domain.dto.CreateAirportRequest;
import com.amadeus.ikramdagci.domain.entity.Airport;
import com.amadeus.ikramdagci.domain.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/airport")
public class AirportController {

    private final AirportService airportService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AirportDto add(CreateAirportRequest request){
        return airportService.create(request);
    }
    @GetMapping
    public Collection<AirportDto> findAll(){
        return airportService.findAll();
    }

    @GetMapping("/{id}")
    public AirportDto findById(@PathVariable Long id){
        return airportService.findById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        airportService.delete(id);
    }

    @PutMapping("/{id}")
    public AirportDto update(@PathVariable Long id,@RequestBody CreateAirportRequest artist){
        return airportService.update(id,artist);
    }


}
