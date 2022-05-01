package com.example.flighttracker.services;

import com.example.flighttracker.models.FlightInfo;
import com.example.flighttracker.repositories.FlightInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class FlightInfoService {

    private final FlightInfoRepository flightInfoRepository;
    private static final int HOUR = 3600 * 1000;

    public Page<FlightInfo> getFlightInfos(Pageable paging, Date updatedBefore){

        Calendar c = Calendar.getInstance();
        c.setTime(updatedBefore);
        c.add(Calendar.HOUR, -1);
        Date updatedAfter = c.getTime();

        System.out.println(updatedAfter);
        System.out.println(updatedBefore);

        return flightInfoRepository.getAllByCoordinates(paging, updatedAfter, updatedBefore);
    }

}
