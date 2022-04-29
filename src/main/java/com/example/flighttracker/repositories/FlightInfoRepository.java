package com.example.flighttracker.repositories;

import com.example.flighttracker.models.FlightInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightInfoRepository extends JpaRepository<FlightInfo, String> {

    //TODO : review this request
    //@Query("select f from flightInfos f where id = (select max(id) from flightInfos f2 where f2.flight_hex = f.flight_hex)")
    @Query("select f from FlightInfo f where (:ne_lat > f.lat and f.lat > :sw_lat) and (:ne_lng > f.lng and f.lng > :sw_lng) and f.id = (select max(f2.id) from FlightInfo f2 where f2.flight.hex = f.flight.hex)")
    Page<FlightInfo> getAllByCoordinates(Pageable paging, double ne_lat, double ne_lng, double sw_lat, double sw_lng);

}
