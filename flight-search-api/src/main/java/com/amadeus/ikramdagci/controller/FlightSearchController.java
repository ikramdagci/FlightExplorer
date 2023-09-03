package com.amadeus.ikramdagci.controller;

import com.amadeus.ikramdagci.domain.model.dto.FlightDto;
import com.amadeus.ikramdagci.domain.model.request.FlightSearchCriteria;
import com.amadeus.ikramdagci.domain.model.response.FlightSearchResponse;
import com.amadeus.ikramdagci.domain.service.FlightSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flight/search")
public class FlightSearchController {

    private final FlightSearchService searchService;
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public FlightSearchResponse findAll(@RequestBody FlightSearchCriteria searchCriteria){
        return searchService.findBy(searchCriteria);
    }

}
