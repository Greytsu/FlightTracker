package com.example.flighttracker.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Plane {

    @Id
    private String regNumber;
    private String aircraft_icao;

}
