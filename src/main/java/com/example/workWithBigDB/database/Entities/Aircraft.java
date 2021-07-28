package com.example.workWithBigDB.database.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aircrafts_data")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String aircraft_code;

    @Column(columnDefinition = "jsonb")
    private String model;

    private int range;


    @OneToMany(mappedBy = "aircraft")
    private List<Flight> flightList;

    @OneToMany(mappedBy = "aircraft",cascade = CascadeType.REMOVE)
    private List<Seat> seatList;

    public Aircraft(){

    }


    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAircraft_code() {
        return aircraft_code;
    }

    public void setAircraft_code(String aircraft_code) {
        this.aircraft_code = aircraft_code;
    }
}
