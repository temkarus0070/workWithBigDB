package com.example.workWithBigDB.database.Entities.Addons;

import javax.persistence.Embeddable;
import java.io.Serializable;


public class LocationPoint implements Serializable {
    private double latitude;
    private double longitude;


    public LocationPoint(double latitude,double longitude){
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public LocationPoint() {

    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
