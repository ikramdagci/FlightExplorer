package com.amadeus.ikramdagci.controller;

import com.amadeus.ikramdagci.domain.model.request.FlightSearchCriteria;
import com.amadeus.ikramdagci.domain.model.response.FlightSearchResponse;
import com.amadeus.ikramdagci.domain.service.FlightSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flight/search")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "2- Flight Search", description = "Endpoints for searching flights - ANY AUTHENTICATED USER")
public class FlightSearchController {

    private final FlightSearchService searchService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Perform a flight search",
            description = "Search for flights based on the provided criteria. "
                    + "If 'returnDate' is specified, it returns both departure and return flights; "
                    + "otherwise, it returns only departure flights."
    )
    public FlightSearchResponse findAll(@RequestBody FlightSearchCriteria searchCriteria) {
        return searchService.findBy(searchCriteria);
    }
}

