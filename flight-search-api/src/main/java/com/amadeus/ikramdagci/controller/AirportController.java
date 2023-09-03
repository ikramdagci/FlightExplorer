package com.amadeus.ikramdagci.controller;

import com.amadeus.ikramdagci.domain.model.dto.AirportDto;
import com.amadeus.ikramdagci.domain.model.request.CreateAirportRequest;
import com.amadeus.ikramdagci.domain.service.AirportService;
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
@RequestMapping("/api/v1/airport")
@PreAuthorize("hasRole('ADMIN')")
@Tag(name = "3- Airport Management - Admin Only", description = "Endpoints for managing airports (ADMIN only)")
public class AirportController {

    private final AirportService airportService;

    /**
     * Create a new airport.
     *
     * @param request The request body containing airport details.
     * @return The created AirportDto.
     */
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new airport", description = "Creates a new airport with the provided details.")
    public AirportDto add(CreateAirportRequest request) {
        return airportService.create(request);
    }

    /**
     * Retrieve a list of all airports.
     *
     * @return A collection of AirportDto.
     */
    @GetMapping
    @Operation(summary = "Get all airports", description = "Retrieves a list of all available airports.")
    public Collection<AirportDto> findAll() {
        return airportService.findAll();
    }

    /**
     * Retrieve an airport by its unique ID.
     *
     * @param id The ID of the airport to retrieve.
     * @return The AirportDto for the specified ID.
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get an airport by ID", description = "Retrieves an airport by its unique ID.")
    public AirportDto findById(@PathVariable Long id) {
        return airportService.findById(id);
    }

    /**
     * Delete an airport by its unique ID.
     *
     * @param id The ID of the airport to delete.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an airport by ID", description = "Deletes an airport by its unique ID.")
    public void delete(@PathVariable Long id) {
        airportService.delete(id);
    }

    /**
     * Update an existing airport by its unique ID.
     *
     * @param id     The ID of the airport to update.
     * @param artist The request body containing updated airport details.
     * @return The updated AirportDto.
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Update an airport by ID", description = "Updates an existing airport by its unique ID.")
    public AirportDto update(@PathVariable Long id, @Valid @RequestBody CreateAirportRequest artist) {
        return airportService.update(id, artist);
    }
}

