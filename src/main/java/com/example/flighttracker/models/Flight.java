package com.example.flighttracker.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Flight")
public class Flight {

    @Id
    private String hex;
    private String flight_number;
    private String flight_icao;
    private String flight_iata;
    private String dep_iata;
    private String dep_icao;
    private String arr_iata;
    private String arr_icao;
    private String airline_icao;
    private String airline_iata;
    private String flag;

    @ManyToOne
    @JoinColumn(name = "plane_reg_number")
    private Plane plane;

    @Override
    public String toString() {
        return "Flight{" +
                "hex='" + hex + '\'' +
                ", flight_number='" + flight_number + '\'' +
                ", flight_icao='" + flight_icao + '\'' +
                ", flight_iata='" + flight_iata + '\'' +
                ", dep_iata='" + dep_iata + '\'' +
                ", dep_icao='" + dep_icao + '\'' +
                ", arr_iata='" + arr_iata + '\'' +
                ", arr_icao='" + arr_icao + '\'' +
                ", airline_icao='" + airline_icao + '\'' +
                ", airline_iata='" + airline_iata + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
