package com.example.workWithBigDB.database.Entities;



import com.example.workWithBigDB.database.Entities.Addons.LocationPoint;
import org.geolatte.geom.G3D;
import org.geolatte.geom.Point;
import org.geolatte.geom.builder.DSL;
import org.geolatte.geom.crs.CoordinateReferenceSystem;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.geolatte.geom.crs.LinearUnit;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "airports_data")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String airport_code;

    private String airport_name;

    public LocationPoint getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LocationPoint coordinates) {
        this.coordinates = coordinates;
    }

    private String city;

    private LocationPoint coordinates;






    private String timezone;

    @OneToMany(mappedBy = "departure_airport")
    private List<Flight> departureFlights;


    @OneToMany(mappedBy = "arrival_airport")
    private List<Flight> arrivalFlights;

    public Airport(){}

    public String getAirport_code() {
        return airport_code;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public String getCity() {
        return city;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setAirport_code(String airport_code) {
        this.airport_code = airport_code;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public List<Flight> getArrivalFlights() {
        return arrivalFlights;
    }

    public void setArrivalFlights(List<Flight> arrivalFlights) {
        this.arrivalFlights = arrivalFlights;
    }

    public List<Flight> getDepartureFlights() {
        return departureFlights;
    }

    public void setDepartureFlights(List<Flight> departureFlights) {
        this.departureFlights = departureFlights;
    }
}
