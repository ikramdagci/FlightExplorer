package com.amadeus.ikramdagci.controller;

import com.amadeus.ikramdagci.domain.entity.Flight;
import com.amadeus.ikramdagci.domain.model.request.CreateFlightRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flight/mockv2")
public class MyController {

    private final String expressAppUrl = "http://localhost:3000";

    @GetMapping
    public ResponseEntity<List<CreateFlightRequest>> makeHttpRequest() {
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<CreateFlightRequest[]> responseEntity = restTemplate.getForEntity(expressAppUrl + "/flights/20", CreateFlightRequest[].class);
        final List<CreateFlightRequest> flightRequests = Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
        return ResponseEntity.ok(flightRequests);
    }

}
