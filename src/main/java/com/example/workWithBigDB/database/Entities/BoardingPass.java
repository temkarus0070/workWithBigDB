package com.example.workWithBigDB.database.Entities;


import com.example.workWithBigDB.database.Entities.IdEmbedable.TicketAndFlight;

import javax.persistence.*;


@Entity
@Table(name = "boarding_passes",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"flight_id","boarding_no"}),
        @UniqueConstraint(columnNames = {"flight_id","seat_no"})
})
public class BoardingPass {
    @EmbeddedId()
    private TicketAndFlight id;

    private int boarding_no;

    private String seat_no;

    @OneToOne()
    @JoinColumns({
            @JoinColumn(name = "ticket_no",referencedColumnName = "ticket_no"),
            @JoinColumn(name = "flight_id",referencedColumnName = "flight_id" )
    }
    )
    private TicketFlight ticketFlight;

    public TicketAndFlight getId() {
        return id;
    }

    public void setId(TicketAndFlight id) {
        this.id = id;
    }

    public TicketFlight getTicketFlight() {
        return ticketFlight;
    }

    public void setTicketFlight(TicketFlight ticketFlight) {
        this.ticketFlight = ticketFlight;
    }

public BoardingPass(){

}

    public int getBoarding_no() {
        return boarding_no;
    }

    public void setBoarding_no(int boarding_no) {
        this.boarding_no = boarding_no;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }
}
