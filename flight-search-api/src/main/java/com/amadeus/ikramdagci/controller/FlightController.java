package com.amadeus.ikramdagci.controller;

import com.amadeus.ikramdagci.domain.model.request.CreateFlightRequest;
import com.amadeus.ikramdagci.domain.model.dto.FlightDto;
import com.amadeus.ikramdagci.domain.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flight")
@PreAuthorize("hasRole('ADMIN')")
@Tag(name = "4- Flight Management - Admin Only", description = "Endpoints for managing flights (ADMIN only)")
public class FlightController {

    private final FlightService flightService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new flight", description = "Creates a new flight with the provided details.")
    public FlightDto add(@RequestBody @Valid CreateFlightRequest request) {
        return flightService.create(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get flights", description = "Retrieves a list of all available flights with pagination support.")
    public Collection<FlightDto> findAll(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        return flightService.findAll(page, size);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a flight by ID", description = "Retrieves a flight by its unique ID.")
    public FlightDto findById(@PathVariable Long id) {
        return flightService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a flight by ID", description = "Deletes a flight by its unique ID.")
    public void delete(@PathVariable Long id) {
        flightService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Update a flight by ID", description = "Updates an existing flight by its unique ID.")
    public FlightDto update(@PathVariable Long id, @Valid @RequestBody CreateFlightRequest request) {
        return flightService.update(id, request);
    }
}

