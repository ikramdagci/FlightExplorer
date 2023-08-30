package com.amadeus.ikramdagci.domain.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Flight extends BaseEntity{

    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime returnDateTime;
    private BigDecimal price;


}
