package com.example.workWithBigDB.database.Entities.IdEmbedable;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SeatId implements Serializable {



    private String aircraft_code;


    private String seat_no;

    public String getAircraft_code() {
        return aircraft_code;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public void setAircraft_code(String aircraft_code) {
        this.aircraft_code = aircraft_code;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatId seatId = (SeatId) o;
        return aircraft_code.equals(seatId.aircraft_code) && seat_no.equals(seatId.seat_no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aircraft_code, seat_no);
    }
}
