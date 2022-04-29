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
    @Query("select f from flightInfos f where id = (select max(id) from flightInfos f2 where f2.flight_hex = f.flight_hex)")
    Page<FlightInfo> getAllByGeolocation(Pageable paging);

}
