package com.example.flighttracker.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightInfo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private double lat;
    private double lng;
    private int alt;
    private int dir;
    private int speed;
    private int v_speed;
    private Timestamp updated;
    private String status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "flight_hex")
    private Flight flight;

}
