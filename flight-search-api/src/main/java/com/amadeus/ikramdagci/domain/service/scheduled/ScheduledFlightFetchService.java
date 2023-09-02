package com.amadeus.ikramdagci.domain.service.scheduled;

import com.amadeus.ikramdagci.domain.model.request.CreateFlightRequest;
import com.amadeus.ikramdagci.domain.service.FlightService;
import com.amadeus.ikramdagci.external.FlightClient;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduledFlightFetchService {

    private final FlightClient flightClient;
    private final FlightService flightService;
    @Value("${api.flight.fetch.count}")
    private int fetchCount;

//    @PostConstruct
    public void fetchFlights() {
        final List<CreateFlightRequest> flights = flightClient.getFlights(fetchCount);
//        flightService
    }

}
