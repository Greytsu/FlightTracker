package com.example.flighttracker.services;

import com.example.flighttracker.models.FlightInfo;
import com.example.flighttracker.repositories.FlightInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightInfoService {

    private final FlightInfoRepository flightInfoRepository;

    public Page<FlightInfo> getFlightInfos(Pageable paging, double ne_lat, double ne_lng, double sw_lat, double sw_lng){
        return flightInfoRepository.getAllByCoordinates(paging, ne_lat, ne_lng, sw_lat, sw_lng);
    }

}
