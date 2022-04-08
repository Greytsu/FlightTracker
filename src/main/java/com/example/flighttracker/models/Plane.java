package com.example.flighttracker.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plane {

    @Id
    private String reg_number;
    private String aircraft_icao;

    @OneToMany(mappedBy = "plane", orphanRemoval = true)
    private List<Flight> flights = new ArrayList<>();

}
