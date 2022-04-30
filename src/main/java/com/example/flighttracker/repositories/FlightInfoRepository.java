package com.example.flighttracker.repositories;

import com.example.flighttracker.models.FlightInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface FlightInfoRepository extends JpaRepository<FlightInfo, String> {

    @Query("select f from FlightInfo f where (:ne_lat > f.lat and f.lat > :sw_lat) and (:ne_lng > f.lng and f.lng > :sw_lng) and f.id = (select max(f2.id) from FlightInfo f2 where f2.flight.hex = f.flight.hex) and :updatedAfter > f.updated and f.updated > :updatedBefore")
    Page<FlightInfo> getAllByCoordinates(Pageable paging, double ne_lat, double ne_lng, double sw_lat, double sw_lng, Date updatedBefore, Date updatedAfter);

}
