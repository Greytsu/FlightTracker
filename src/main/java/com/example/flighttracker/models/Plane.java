package com.example.flighttracker.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "Plane")
public class Plane {

    @Id
    private String regNumber;
    private String aircraft_icao;

}
