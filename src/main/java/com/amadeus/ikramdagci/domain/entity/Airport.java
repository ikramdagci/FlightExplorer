package com.amadeus.ikramdagci.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_airport")
public class Airport extends BaseEntity{

    private String city;

}
