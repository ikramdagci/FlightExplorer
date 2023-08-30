package com.amadeus.ikramdagci.controller;

import com.amadeus.ikramdagci.domain.dto.CreateAirportRequest;
import com.amadeus.ikramdagci.domain.entity.Airport;
import com.amadeus.ikramdagci.domain.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/airport")
//@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class AirportController {

    private final AirportService airportService;
    @PostMapping("/add")
    public Airport add(CreateAirportRequest request){
        return airportService.create(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id){
        airportService.delete(id);
    }


}
