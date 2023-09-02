package com.amadeus.ikramdagci.external;

import com.amadeus.ikramdagci.domain.model.request.CreateFlightRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface FlightClient {

    @GetExchange("/flight")
    CreateFlightRequest getFlight();

    @GetExchange("/flights/{flightCount}")
    List<CreateFlightRequest> getFlights(@PathVariable int flightCount);

}
