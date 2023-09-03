package com.amadeus.ikramdagci.domain.model.response;

import com.amadeus.ikramdagci.domain.model.dto.FlightDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FlightSearchResponse {

    private Collection<FlightDto> departureFlights;
    private Collection<FlightDto> returnFlights;


}
