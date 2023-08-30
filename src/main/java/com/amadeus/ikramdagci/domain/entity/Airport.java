package com.amadeus.ikramdagci.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_airport")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Airport extends BaseEntity{

    private String city;
    private String code;

}
