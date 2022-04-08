package com.example.flighttracker.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @Column(nullable = false)
    private String hex;
    private String flight_number;
    private String flight_icao;
    private String dep_iata;
    private String dep_icao;
    private String arr_iata;
    private String arr_icao;
    private String airline_icao;
    private String airline_iata;
    private String flag;

    @OneToMany(mappedBy = "flight", orphanRemoval = true)
    private List<FlightInfo> flightInfos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "plane_reg_number")
    private Plane plane;

    public Flight(String hex, String flight_number, String flight_icao, String dep_iata, String dep_icao, String arr_iata, String arr_icao, String airline_icao, String airline_iata) {
        this.hex = hex;
        this.flight_number = flight_number;
        this.flight_icao = flight_icao;
        this.dep_iata = dep_iata;
        this.dep_icao = dep_icao;
        this.arr_iata = arr_iata;
        this.arr_icao = arr_icao;
        this.airline_icao = airline_icao;
        this.airline_iata = airline_iata;
    }
}
