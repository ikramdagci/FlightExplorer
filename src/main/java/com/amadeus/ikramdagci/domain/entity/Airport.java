package com.amadeus.ikramdagci.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_airport")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Airport extends BaseEntity{

    private String city;

}
