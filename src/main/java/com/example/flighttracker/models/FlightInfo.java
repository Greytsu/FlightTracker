package com.example.flighttracker.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private double v_speed;
    private Date updated;
    private String status;

    @ManyToOne
    @JoinColumn(name = "flight_hex")
    private Flight flight;

    @Override
    public String toString() {
        return "FlightInfo{" +
                "id='" + id + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", alt=" + alt +
                ", dir=" + dir +
                ", speed=" + speed +
                ", v_speed=" + v_speed +
                ", updated=" + updated +
                ", status='" + status + '\'' +
                '}';
    }
}
