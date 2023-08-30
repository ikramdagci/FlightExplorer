package com.amadeus.ikramdagci.domain.entity;

import com.amadeus.ikramdagci.converter.MonetaryAmountConverter;
import jakarta.persistence.*;

import javax.money.MonetaryAmount;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_flight")
public class Flight extends BaseEntity{

    @ManyToOne
    private Airport departureAirport;
    @ManyToOne
    private Airport arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount price;


}
