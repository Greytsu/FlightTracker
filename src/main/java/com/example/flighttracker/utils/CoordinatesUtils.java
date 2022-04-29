package com.example.flighttracker.utils;

public class CoordinatesUtils {

    public static boolean CoordinatesCheck(double ne_lat, double ne_lng, double sw_lat, double sw_lng){
        if (-90 > ne_lat || ne_lat > 90 || -180 > ne_lng || ne_lng > 180 || -90 > sw_lat || sw_lat > 90 || -180 > sw_lng || sw_lng > 180)
            return false;

        return (ne_lat > sw_lat && ne_lng > sw_lng);
    }

}
