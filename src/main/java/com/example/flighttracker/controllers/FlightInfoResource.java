package com.example.flighttracker.controllers;

import com.example.flighttracker.services.FlightInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/flightInfo")
public class FlightInfoResource {

    private static final int HOUR = 3600 * 1000;
    private final FlightInfoService flightInfoService;

    //TODO : add request params for map corners
    @GetMapping
    public ResponseEntity<Object> getFlightInfos(
            @RequestParam(defaultValue = "0", name = "page") int page,
            @RequestParam(defaultValue = "100", name = "size") int size,
            @RequestParam(name = "timestamp", required = false) Timestamp timestamp
    ){

        Date updatedAt = null == timestamp
                ? new Date(System.currentTimeMillis() - HOUR)
                : new Date(timestamp.getTime());

        Pageable paging = PageRequest.of(page, size);

        try {
            return new ResponseEntity<>(flightInfoService.getFlightInfos(paging, updatedAt), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
