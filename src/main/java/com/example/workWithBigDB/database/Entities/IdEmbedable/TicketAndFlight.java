package com.example.workWithBigDB.database.Entities.IdEmbedable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class TicketAndFlight implements Serializable {


    @Column(name = "ticket_no",nullable = false,insertable = false,updatable = false)
    private String ticket_no;


    @Column(name = "flight_id",nullable = false,insertable = false,updatable = false)
    private int flight_id;

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getTicket_no() {
        return ticket_no;
    }

    public void setTicket_no(String ticket_no) {
        this.ticket_no = ticket_no;
    }

    public TicketAndFlight(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketAndFlight that = (TicketAndFlight) o;
        return flight_id == that.flight_id && ticket_no.equals(that.ticket_no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket_no, flight_id);
    }
}
