package com.example.flighttracker.services;

import com.example.flighttracker.models.Plane;
import com.example.flighttracker.repositories.PlaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaneService {

    private final PlaneRepository planeRepository;

    public Plane savePlane(Plane plane){
        return planeRepository.save(plane);
    }
}
