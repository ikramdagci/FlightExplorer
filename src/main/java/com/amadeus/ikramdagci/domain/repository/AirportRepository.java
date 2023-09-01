package com.amadeus.ikramdagci.domain.repository;

import com.amadeus.ikramdagci.domain.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {

    Airport findByCode(String code);

    default void executeNativeQuery(String query){

    }

}
