package com.example.flighttracker.services;

import com.example.flighttracker.models.FlightInfo;
import com.example.flighttracker.repositories.FlightInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightInfoService {

    private final FlightInfoRepository flightInfoRepository;

    public FlightInfo saveFlightInfo(FlightInfo flightInfo){
        return flightInfoRepository.save(flightInfo);
    }

}
