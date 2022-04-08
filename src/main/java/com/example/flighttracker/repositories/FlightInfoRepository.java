package com.example.flighttracker.repositories;

import com.example.flighttracker.models.FlightInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightInfoRepository extends JpaRepository<FlightInfo, String> {
}
