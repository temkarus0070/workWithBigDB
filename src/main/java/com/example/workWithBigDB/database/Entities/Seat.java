package com.example.workWithBigDB.database.Entities;


import com.example.workWithBigDB.database.Entities.IdEmbedable.SeatId;

import javax.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    private SeatId seatId;


    private String fare_conditions;


    @ManyToOne()
    @JoinColumn(name = "aircraft_code")
    private Aircraft aircraft;


    public Seat(){

    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public SeatId getSeatId() {
        return seatId;
    }

    public void setSeatId(SeatId seatId) {
        this.seatId = seatId;
    }

    public void setFare_conditions(String fare_conditions) {
        this.fare_conditions = fare_conditions;
    }

    public String getFare_conditions() {
        return fare_conditions;
    }


}
