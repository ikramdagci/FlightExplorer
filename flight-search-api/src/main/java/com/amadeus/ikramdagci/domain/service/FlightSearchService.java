package com.amadeus.ikramdagci.domain.service;

import com.amadeus.ikramdagci.domain.ex.FlightNotFoundException;
import com.amadeus.ikramdagci.domain.model.dto.FlightDto;
import com.amadeus.ikramdagci.domain.model.request.FlightSearchCriteria;
import com.amadeus.ikramdagci.domain.model.response.FlightSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FlightSearchService {

    private final FlightService flightService;
    public FlightSearchResponse findBy(final FlightSearchCriteria sc) {
        final Collection<FlightDto> departureFlights = flightService.findFlights(sc.getDepartureAirportCode(), sc.getArrivalAirportCode(), sc.getDepartureDate());
        Collection<FlightDto> returnFlights = Collections.emptyList();
        new BeanPropertyBindingResult(sc,"SearchCriteria");
        if(Objects.nonNull(sc.getReturnDate())){
            if(sc.getReturnDate().isBefore(sc.getDepartureDate())) throw new FlightNotFoundException("Return date cannot be before the departure date."); // TODO: 3.09.2023 Create validation for this case
            returnFlights = flightService.findFlights(sc.getArrivalAirportCode(), sc.getDepartureAirportCode(), sc.getReturnDate());
        }
        return new FlightSearchResponse(departureFlights,returnFlights);
    }
}
