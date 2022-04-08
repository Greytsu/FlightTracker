package com.example.flighttracker.services;

import com.example.flighttracker.models.Flight;
import com.example.flighttracker.repositories.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public Flight saveFlight(Flight flight){
        return flightRepository.save(flight);
    }
}
