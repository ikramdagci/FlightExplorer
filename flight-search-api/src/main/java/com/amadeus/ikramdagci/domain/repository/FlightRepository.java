package com.amadeus.ikramdagci.domain.repository;

import com.amadeus.ikramdagci.domain.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Flight f WHERE f.arrivalAirport.id = :airportId OR f.departureAirport.id = :airportId")
    void deleteByDepartureOrArrivalAirportId(@Param("airportId") Long airportId);

    @Query("SELECT f FROM Flight f WHERE f.arrivalAirport.id = :airportId OR f.departureAirport.id = :airportId")
    List<Flight> findIdsByAirport(@Param("airportId") Long airportId);

    List<Flight> findByDepartureDateTimeBetweenAndDepartureAirportCodeAndArrivalAirportCode(
            LocalDateTime start,
            LocalDateTime end,
            String departureAirportCode,
            String arrivalAirportCode
    );


}
