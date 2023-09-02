package com.amadeus.ikramdagci.domain.model.request;


import com.amadeus.ikramdagci.domain.model.CreateFlightPayload;
import com.amadeus.ikramdagci.validation.FlightArrivalNotBeforeDeparture;
import com.amadeus.ikramdagci.domain.model.MonetaryAmountWrapper;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


public class CreateFlightRequest extends CreateFlightPayload {}
