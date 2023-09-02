package com.amadeus.ikramdagci.domain.service.scheduled;

import com.amadeus.ikramdagci.domain.model.response.FlightResponse;
import com.amadeus.ikramdagci.domain.service.FlightService;
import com.amadeus.ikramdagci.external.FlightClient;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduledFlightFetchService {

    private final FlightClient flightClient;
    private final FlightService flightService;
    @Value("${api.flight.fetch.count}")
    private int fetchCount;

//        @PostConstruct
    @Scheduled(fixedDelay = 30000)
    public void fetchFlights() {
        final List<FlightResponse> flights = flightClient.getFlights(fetchCount);
        flightService.create(flights);
        log.info("{} flights received from the API have been added to the database.",fetchCount);
    }

}
