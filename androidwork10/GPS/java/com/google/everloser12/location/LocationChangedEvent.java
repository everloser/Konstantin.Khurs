package com.google.everloser12.location;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by al-ev on 17.04.2016.
 */
public class LocationChangedEvent {
    public final float lat;
    public final float lon;
    public  String TIME;

    public LocationChangedEvent(float lat, float lon) {
        this.lat = lat;
        this.lon = lon;
    }



    @Override public String toString() {
        TIME = DateFormat.getTimeInstance().format(new Date());
        return new StringBuilder("Latitude = ") //
                .append(lat) //
                .append(", Longitude = ") //
                .append(lon) //
                .append(". At time : ")
                 .append(TIME)//
                .toString();
    }
}