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

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "flightTracker/api/v1/flightInfo")
public class FlightInfoResource {

    private final FlightInfoService flightInfoService;

    //TODO : add request params for map corners
    @GetMapping
    public ResponseEntity<Object> getFlightInfos(
            @RequestParam(defaultValue = "0", name = "page") int page,
            @RequestParam(defaultValue = "100", name = "size") int size
    ){
        Pageable paging = PageRequest.of(page, size);

        try {
            return new ResponseEntity<>(flightInfoService.getFlightInfos(paging), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
