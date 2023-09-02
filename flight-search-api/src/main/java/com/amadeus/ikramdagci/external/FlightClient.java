package com.amadeus.ikramdagci.external;

import com.amadeus.ikramdagci.domain.model.request.CreateFlightRequest;
import com.amadeus.ikramdagci.domain.model.response.FlightResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface FlightClient {

    @GetExchange("/flight")
    FlightResponse getFlight();

    @GetExchange("/flights/{flightCount}")
    List<FlightResponse> getFlights(@PathVariable int flightCount);

}
