package com.example.flighttracker;

import com.example.flighttracker.models.Flight;
import com.example.flighttracker.models.FlightInfo;
import com.example.flighttracker.models.Plane;
import com.example.flighttracker.services.FlightInfoService;
import com.example.flighttracker.services.FlightService;
import com.example.flighttracker.services.PlaneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.List;

@SpringBootApplication
public class FlightTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightTrackerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(FlightService flightService, FlightInfoService flightInfoService, PlaneService planeService) {
        return args -> {
            boolean enable = false;

            if(enable){
                flightService.saveFlight(Flight.builder()
                        .hex("106981")
                        .flight_number("30MA27")
                        .flight_icao("NOV30MA27")
                        .dep_iata("KHV")
                        .dep_icao("UHHH")
                        .arr_iata("")
                        .arr_icao("")
                        .airline_iata("O9")
                        .airline_icao("NOV")
                        .flag("IT")
                        .build());

                flightInfoService.saveFlightInfo(FlightInfo.builder()
                        .lat(48.53)
                        .lng(135.18)
                        .alt(0)
                        .dir(39)
                        .speed(16)
                        .v_speed(0)
                        .updated(new Timestamp(1649408341))
                        .status("en-route")
                        .build());

                planeService.savePlane(Plane.builder()
                        .reg_number("RA-67072")
                        .aircraft_icao("L410")
                        .build());
            }

        };
    }
}
